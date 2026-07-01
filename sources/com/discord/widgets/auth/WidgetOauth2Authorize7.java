package com.discord.widgets.auth;

import com.discord.widgets.auth.WidgetOauth2Authorize;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$oauth2ViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize7 extends Lambda implements Function0<WidgetOauth2Authorize.OAuth2ViewModel> {
    public static final WidgetOauth2Authorize7 INSTANCE = new WidgetOauth2Authorize7();

    public WidgetOauth2Authorize7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetOauth2Authorize.OAuth2ViewModel invoke() {
        return new WidgetOauth2Authorize.OAuth2ViewModel();
    }
}
