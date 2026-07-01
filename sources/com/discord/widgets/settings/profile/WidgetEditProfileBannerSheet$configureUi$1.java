package com.discord.widgets.settings.profile;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$configureUi$1 implements View$OnClickListener {
    public final /* synthetic */ Ref$ObjectRef $bannerColor;
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    public WidgetEditProfileBannerSheet$configureUi$1(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, Ref$ObjectRef ref$ObjectRef) {
        this.this$0 = widgetEditProfileBannerSheet;
        this.$bannerColor = ref$ObjectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = this.this$0;
        Integer num = (Integer) this.$bannerColor.element;
        WidgetEditProfileBannerSheet.access$launchColorPicker(widgetEditProfileBannerSheet, num != null ? num.intValue() : WidgetEditProfileBannerSheet.access$getDefaultBannerColor$p(widgetEditProfileBannerSheet));
    }
}
