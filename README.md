# DietaDataRepo

Repositorio de datos (JSON) para una app Android.

## Estructura
- `data/index.json` -> lista de meses y rutas.
- `data/<mes_id>/dieta.json`
- `data/<mes_id>/recetas.json`

## Cómo consumir desde Android (GitHub raw)

Ejemplo con OkHttp (sin librerías extra):

```kotlin
val base = "https://raw.githubusercontent.com/<USUARIO>/<REPO>/main/"
val indexUrl = base + "data/index.json"
```

Luego, para un mes:
```kotlin
val dietaUrl = base + "data/enero_2026/dieta.json"
val recetasUrl = base + "data/enero_2026/recetas.json"
```

Recomendación: cachear los JSON en almacenamiento interno.

## Convenciones
En `dieta.json`, cada comida contiene items:
- `{ "alimento": "Kiwi", "gramos": 150 }`
- `{ "receta_id": "ensalada_de_manzana_y_queso", "gramos": 320 }`

En `recetas.json`, cada receta tiene:
- `id`, `nombre`, `cantidad`, `kcal`, `ingredientes[]`, `preparacion`
