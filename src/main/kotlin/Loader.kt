@file:JsModule("@googlemaps/js-api-loader")
@file:JsNonModule
import kotlin.js.Promise




external class Loader(
    loaderOptions: LoaderOptions
) {
    fun load(): Promise<Unit>
}

external interface LoaderOptions {
    var apiKey: String
    var version: String
}
