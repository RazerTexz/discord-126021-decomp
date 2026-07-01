package com.discord.widgets.guilds.profile;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetAnnouncementGuildProfileSheetBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetPublicAnnouncementProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPublicAnnouncementProfileSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetPublicAnnouncementProfileSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAnnouncementGuildProfileSheetBinding;", 0)};
    public static final WidgetPublicAnnouncementProfileSheet$Companion Companion = new WidgetPublicAnnouncementProfileSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetPublicAnnouncementProfileSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPublicAnnouncementProfileSheet$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetAnnouncementGuildProfileSheetBinding getBinding() {
        return (WidgetAnnouncementGuildProfileSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        Companion.show(fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_announcement_guild_profile_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SimpleDraweeView simpleDraweeView = getBinding().f2225b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.announcementGuildAvatar");
        IconUtils.setIcon$default(simpleDraweeView, "asset://asset/images/system_user_avatar.png", 2131165302, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
    }
}
