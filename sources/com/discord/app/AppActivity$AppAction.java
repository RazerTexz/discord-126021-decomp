package com.discord.app;

import android.os.Bundle;
import d0.g;
import kotlin.Lazy;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$AppAction extends AppActivity {

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final Lazy screen = g.lazy(new AppActivity$AppAction$a(this));

    @Override // com.discord.app.AppActivity
    public Class<? extends AppComponent> d() {
        return (Class) this.screen.getValue();
    }

    @Override // com.discord.app.AppActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppActivity.m) {
            finish();
        }
    }
}
