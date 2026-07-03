package com.discord.widgets.guilds.profile;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetAnnouncementGuildProfileSheetBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetPublicAnnouncementProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPublicAnnouncementProfileSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetPublicAnnouncementProfileSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAnnouncementGuildProfileSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetPublicAnnouncementProfileSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetPublicAnnouncementProfileSheet().show(fragmentManager, WidgetPublicAnnouncementProfileSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetPublicAnnouncementProfileSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPublicAnnouncementProfileSheet$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetAnnouncementGuildProfileSheetBinding getBinding() {
        return (WidgetAnnouncementGuildProfileSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        INSTANCE.show(fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_announcement_guild_profile_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SimpleDraweeView simpleDraweeView = getBinding().f15649b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.announcementGuildAvatar");
        IconUtils.setIcon$default(simpleDraweeView, "asset://asset/images/system_user_avatar.png", C5419R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
    }
}
