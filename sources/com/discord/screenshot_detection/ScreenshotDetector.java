package com.discord.screenshot_detection;

import android.app.Application;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import b.a.s.a;
import b.a.s.b;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ScreenshotDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenshotDetector {
    public static ScreenshotDetector a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final PublishSubject<ScreenshotDetector$Screenshot> publishSubject;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final b screenshotContentObserver;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final a activityCallbacks;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean enabled;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Logger logger;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final SharedPreferences cache;

    public ScreenshotDetector(Application application, Logger logger, SharedPreferences sharedPreferences) {
        m.checkNotNullParameter(application, "applicationContext");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(sharedPreferences, "cache");
        this.logger = logger;
        this.cache = sharedPreferences;
        PublishSubject<ScreenshotDetector$Screenshot> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.publishSubject = publishSubjectK0;
        ContentResolver contentResolver = application.getContentResolver();
        m.checkNotNullExpressionValue(contentResolver, "applicationContext.contentResolver");
        b bVar = new b(logger, contentResolver, null, new ScreenshotDetector$a(this), 4);
        this.screenshotContentObserver = bVar;
        a aVar = new a(bVar);
        this.activityCallbacks = aVar;
        a(sharedPreferences.getBoolean("screenshot_detection_enabled", false));
        application.registerActivityLifecycleCallbacks(aVar);
        aVar.a(this.enabled);
    }

    public final void a(boolean z2) {
        this.enabled = z2;
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.cache.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putBoolean("screenshot_detection_enabled", z2);
        sharedPreferences$EditorEdit.apply();
        this.activityCallbacks.a(z2);
    }
}
