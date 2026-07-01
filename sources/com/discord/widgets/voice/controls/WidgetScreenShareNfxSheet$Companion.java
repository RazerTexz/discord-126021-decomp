package com.discord.widgets.voice.controls;

import android.content.SharedPreferences$Editor;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetScreenShareNfxSheet$Companion {
    private WidgetScreenShareNfxSheet$Companion() {
    }

    public static /* synthetic */ void show$default(WidgetScreenShareNfxSheet$Companion widgetScreenShareNfxSheet$Companion, FragmentManager fragmentManager, long j, long j2, WidgetScreenShareNfxSheet$VoiceBottomSheetParams widgetScreenShareNfxSheet$VoiceBottomSheetParams, int i, Object obj) {
        if ((i & 8) != 0) {
            widgetScreenShareNfxSheet$VoiceBottomSheetParams = null;
        }
        widgetScreenShareNfxSheet$Companion.show(fragmentManager, j, j2, widgetScreenShareNfxSheet$VoiceBottomSheetParams);
    }

    public final boolean canShow() {
        return !SharedPreferencesProvider.INSTANCE.get().getBoolean("CACHE_KEY_SCREEN_SHARE_NFX_SHEET_SHOWN", false);
    }

    public final void show(FragmentManager fragmentManager, long channelId, long guildId, WidgetScreenShareNfxSheet$VoiceBottomSheetParams voiceBottomSheetParams) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetScreenShareNfxSheet widgetScreenShareNfxSheet = new WidgetScreenShareNfxSheet();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        bundleT.putSerializable("ARG_VOICE_BOTTOM_SHEET_PARAMS", voiceBottomSheetParams);
        widgetScreenShareNfxSheet.setArguments(bundleT);
        widgetScreenShareNfxSheet.show(fragmentManager, WidgetScreenShareNfxSheet.class.getName());
        SharedPreferences$Editor sharedPreferences$EditorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putBoolean("CACHE_KEY_SCREEN_SHARE_NFX_SHEET_SHOWN", true);
        sharedPreferences$EditorEdit.apply();
    }

    public /* synthetic */ WidgetScreenShareNfxSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
