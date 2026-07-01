package com.discord.widgets.user;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetBanUserBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetBanUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetBanUser extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetBanUser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBanUserBinding;", 0)};
    public static final WidgetBanUser$Companion Companion = new WidgetBanUser$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager deleteHistoryRadioManager;

    public WidgetBanUser() {
        super(R$layout.widget_ban_user);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetBanUser$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetBanUserBinding access$getBinding$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.getBinding();
    }

    public static final /* synthetic */ RadioManager access$getDeleteHistoryRadioManager$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.deleteHistoryRadioManager;
    }

    public static final /* synthetic */ List access$getHistoryRadios$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.getHistoryRadios();
    }

    public static final /* synthetic */ void access$setDeleteHistoryRadioManager$p(WidgetBanUser widgetBanUser, RadioManager radioManager) {
        widgetBanUser.deleteHistoryRadioManager = radioManager;
    }

    private final WidgetBanUserBinding getBinding() {
        return (WidgetBanUserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getHistoryRadios() {
        CheckedSetting checkedSetting = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting, "binding.banUserDeleteMessagesNone");
        CheckedSetting checkedSetting2 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.banUserDeleteMessages1Day");
        CheckedSetting checkedSetting3 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.banUserDeleteMessages7Days");
        return n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    public static final void launch(String str, long j, long j2, FragmentManager fragmentManager) {
        Companion.launch(str, j, j2, fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.deleteHistoryRadioManager = new RadioManager(getHistoryRadios());
        for (CheckedSetting checkedSetting : getHistoryRadios()) {
            checkedSetting.e(new WidgetBanUser$onViewBound$$inlined$forEach$lambda$1(checkedSetting, this));
        }
        String string = getArgumentsOrDefault().getString("com.discord.intent.extra.EXTRA_USER_NAME", "");
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.banUserTitle");
        b.n(textView, 2131887009, new Object[]{string}, null, 4);
        TextView textView2 = getBinding().f2240b;
        m.checkNotNullExpressionValue(textView2, "binding.banUserBody");
        b.n(textView2, 2131887005, new Object[]{string}, null, 4);
        getBinding().c.setOnClickListener(new WidgetBanUser$onViewBound$2(this));
        getBinding().d.setOnClickListener(new WidgetBanUser$onViewBound$3(this, j, j2, string));
    }
}
