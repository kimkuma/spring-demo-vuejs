import Vue2Filters from 'vue2-filters'

export default {
    mixins: [Vue2Filters.mixin],
    data() {
        this.getState()

        return {
            state: window.state
        }
    },
    methods: {
        getState() {
            async function state() {
                let response = await $http.get('/api/state')
                return response
            }

            state().then((res) => {
                this.state = res.data
            })
        }
    }
}