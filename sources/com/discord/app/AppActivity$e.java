package com.discord.app;

import android.content.Intent;
import com.discord.widgets.tabs.WidgetTabsHost;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$e extends o implements Function0<Class<? extends AppComponent>> {
    public final /* synthetic */ AppActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppActivity$e(AppActivity appActivity) {
        super(0);
        this.this$0 = appActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public Class<? extends AppComponent> invoke() {
        Intent intent = this.this$0.getIntent();
        Class<? extends AppComponent> cls = (Class) (intent != null ? intent.getSerializableExtra("com.discord.intent.extra.EXTRA_SCREEN") : null);
        return cls != null ? cls : WidgetTabsHost.class;
    }
}
