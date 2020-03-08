import Vue2Filters from 'vue2-filters'

export default {
    mixins: [Vue2Filters.mixin],
    data() {
        return {
            state: window.state
        }
    }
}