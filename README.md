# Snake APK

Этот проект собирает APK с игрой «Змейка», которая запускается внутри WebView.

## Требования
- Android SDK (platforms;android-34 и build-tools).
- JDK 17+.
- Gradle (можно использовать системный `gradle`, wrapper не добавлен).

## Сборка APK
```bash
gradle assembleDebug
```

Готовый APK будет в:
```
app/build/outputs/apk/debug/app-debug.apk
```

## Обновление игры
HTML-верстка игры находится в `app/src/main/assets/index.html`.
