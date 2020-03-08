<template>
    <div>
        <section v-if="!state.name">
            Not Logined User. 2

            <p>Can you <a href="/login">login</a>?</p>
        </section>
        <section v-else>
            <p>Hi {{state.name}}.</p>
            <p>Your current session id is {{state.id}}.</p>
            <p><a href="/logout">logout</a></p>
        </section>
    </div>
</template>
<script>
    import CommonMixin from '~/vue/common/mixins/common-mixin'

    export default {
        mixins: [CommonMixin],
        data() {
            return {

            }
        }
    }
</script>