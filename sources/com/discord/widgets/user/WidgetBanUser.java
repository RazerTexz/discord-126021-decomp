package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetBanUserBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetBanUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetBanUser extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetBanUser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBanUserBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager deleteHistoryRadioManager;

    /* JADX INFO: compiled from: WidgetBanUser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(String userName, long guildId, long userId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(userName, "userName");
            if (fragmentManager == null) {
                return;
            }
            WidgetBanUser widgetBanUser = new WidgetBanUser();
            Bundle bundle = new Bundle();
            bundle.putString("com.discord.intent.extra.EXTRA_USER_NAME", userName);
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundle.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
            widgetBanUser.setArguments(bundle);
            widgetBanUser.show(fragmentManager, WidgetBanUser.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetBanUser() {
        super(R.layout.widget_ban_user);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetBanUser2.INSTANCE, null, 2, null);
    }

    private final WidgetBanUserBinding getBinding() {
        return (WidgetBanUserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getHistoryRadios() {
        CheckedSetting checkedSetting = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.banUserDeleteMessagesNone");
        CheckedSetting checkedSetting2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.banUserDeleteMessages1Day");
        CheckedSetting checkedSetting3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.banUserDeleteMessages7Days");
        return Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    public static final void launch(String str, long j, long j2, FragmentManager fragmentManager) {
        INSTANCE.launch(str, j, j2, fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.deleteHistoryRadioManager = new RadioManager(getHistoryRadios());
        for (final CheckedSetting checkedSetting : getHistoryRadios()) {
            checkedSetting.e(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetBanUser$onViewBound$$inlined$forEach$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RadioManager radioManager = this.deleteHistoryRadioManager;
                    if (radioManager != null) {
                        radioManager.a(checkedSetting);
                    }
                }
            });
        }
        final String string = getArgumentsOrDefault().getString("com.discord.intent.extra.EXTRA_USER_NAME", "");
        final long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        final long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.banUserTitle");
        FormatUtils.m(textView, R.string.ban_user_title, new Object[]{string}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = getBinding().f2240b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.banUserBody");
        FormatUtils.m(textView2, R.string.ban_user_body, new Object[]{string}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetBanUser.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetBanUser.this.dismiss();
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetBanUser.onViewBound.3

            /* JADX INFO: renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetBanUser.kt */
            public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r7) {
                    Context context = WidgetBanUser.this.getContext();
                    Context context2 = WidgetBanUser.this.getContext();
                    AppToast.h(context, context2 != null ? FormatUtils.b(context2, R.string.ban_user_confirmed, new Object[]{string}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null, 0, null, 12);
                    WidgetBanUser.this.dismiss();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i;
                List historyRadios = WidgetBanUser.this.getHistoryRadios();
                RadioManager radioManager = WidgetBanUser.this.deleteHistoryRadioManager;
                switch (((CheckedSetting) historyRadios.get(radioManager != null ? radioManager.b() : 0)).getId()) {
                    case R.id.ban_user_delete_messages_1_day /* 2131362131 */:
                        i = 1;
                        break;
                    case R.id.ban_user_delete_messages_7_days /* 2131362132 */:
                        i = 7;
                        break;
                    case R.id.ban_user_delete_messages_none /* 2131362133 */:
                    default:
                        i = 0;
                        break;
                }
                TextInputLayout textInputLayout = WidgetBanUser.this.getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.banUserReason");
                String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().banGuildMember(j, j2, new RestAPIParams.BanGuildMember(Integer.valueOf(i)), StringsJVM.isBlank(textOrEmpty) ^ true ? textOrEmpty : null), false, 1, null), WidgetBanUser.this, null, 2, null), (Class<?>) WidgetBanUser.this.getClass(), (58 & 2) != 0 ? null : WidgetBanUser.this.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            }
        });
    }
}
