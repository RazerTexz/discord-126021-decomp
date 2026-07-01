package com.discord.widgets.user.account;

import d0.z.d.w;

/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserAccountVerify$onViewBound$1 extends w {
    public WidgetUserAccountVerify$onViewBound$1(WidgetUserAccountVerify widgetUserAccountVerify) {
        super(widgetUserAccountVerify, WidgetUserAccountVerify.class, "isForced", "isForced()Z", 0);
    }

    @Override // d0.z.d.w, kotlin.reflect.KProperty0
    public Object get() {
        return Boolean.valueOf(((WidgetUserAccountVerify) this.receiver).isForced());
    }
}
