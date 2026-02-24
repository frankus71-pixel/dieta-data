package com.tuapp.data

import okhttp3.OkHttpClient
import okhttp3.Request

class GithubJsonClient(
    private val baseRawUrl: String, // e.g. https://raw.githubusercontent.com/user/repo/main/
    private val http: OkHttpClient = OkHttpClient()
) {
    fun get(url: String): String {
        val req = Request.Builder().url(url).build()
        http.newCall(req).execute().use { resp ->
            if (!resp.isSuccessful) error("HTTP ${'$'}{resp.code}: ${'$'}url")
            return resp.body?.string() ?: ""
        }
    }

    fun indexJson(): String = get(baseRawUrl + "data/index.json")
    fun dietaJson(monthId: String): String = get(baseRawUrl + "data/${'$'}monthId/dieta.json")
    fun recetasJson(monthId: String): String = get(baseRawUrl + "data/${'$'}monthId/recetas.json")
}
