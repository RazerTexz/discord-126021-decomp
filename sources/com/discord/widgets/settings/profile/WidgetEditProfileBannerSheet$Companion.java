package com.discord.widgets.settings.profile;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$Companion {
    private WidgetEditProfileBannerSheet$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(WidgetEditProfileBannerSheet$Companion widgetEditProfileBannerSheet$Companion, Long l, String str, String str2, boolean z2, FragmentManager fragmentManager, Function0 function0, Function0 function1, Function1 function2, int i, Object obj) {
        widgetEditProfileBannerSheet$Companion.show((i & 1) != 0 ? null : l, str, str2, z2, fragmentManager, (i & 32) != 0 ? WidgetEditProfileBannerSheet$Companion$show$1.INSTANCE : function0, (i & 64) != 0 ? WidgetEditProfileBannerSheet$Companion$show$2.INSTANCE : function1, (i & 128) != 0 ? WidgetEditProfileBannerSheet$Companion$show$3.INSTANCE : function2);
    }

    public final void show(Long guildId, String defaultBannerColorHex, String initialColorPreviewHex, boolean hasBannerImage, FragmentManager fragmentManager, Function0<Unit> onChangeProfileBannerImage, Function0<Unit> onRemoveProfileBannerImage, Function1<? super Integer, Unit> onColorSelected) {
        m.checkNotNullParameter(defaultBannerColorHex, "defaultBannerColorHex");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(onChangeProfileBannerImage, "onChangeProfileBannerImage");
        m.checkNotNullParameter(onRemoveProfileBannerImage, "onRemoveProfileBannerImage");
        m.checkNotNullParameter(onColorSelected, "onColorSelected");
        WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = new WidgetEditProfileBannerSheet();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_DEFAULT_BANNER_COLOR_HEX", defaultBannerColorHex);
        bundle.putString("ARG_INITIAL_COLOR_PREVIEW_HEX", initialColorPreviewHex);
        bundle.putBoolean("ARG_HAS_BANNER_IMAGE", hasBannerImage);
        if (guildId != null) {
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
        }
        widgetEditProfileBannerSheet.setArguments(bundle);
        widgetEditProfileBannerSheet.setOnChangeProfileBannerImage(onChangeProfileBannerImage);
        widgetEditProfileBannerSheet.setOnRemoveProfileBannerImage(onRemoveProfileBannerImage);
        widgetEditProfileBannerSheet.setOnColorSelected(onColorSelected);
        widgetEditProfileBannerSheet.show(fragmentManager, WidgetEditProfileBannerSheet.class.getName());
    }

    public /* synthetic */ WidgetEditProfileBannerSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
