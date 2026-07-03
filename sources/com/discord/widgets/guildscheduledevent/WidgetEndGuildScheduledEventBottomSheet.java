package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetEndStageBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndGuildScheduledEventBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEndGuildScheduledEventBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEndStageBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REQUEST_KEY = "INTENT_EXTRA_REQUEST_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: guildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy guildScheduledEventId;

    /* JADX INFO: renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;

    /* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function0<Unit> onActionTaken) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            C12238m.checkNotNullParameter(onActionTaken, "onActionTaken");
            FragmentKt.setFragmentResultListener(fragment, requestKey, new C8840x74fb94df(requestKey, onActionTaken));
        }

        public final void show(FragmentManager fragmentManager, String requestKey, long guildId, long guildScheduledEventId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            WidgetEndGuildScheduledEventBottomSheet widgetEndGuildScheduledEventBottomSheet = new WidgetEndGuildScheduledEventBottomSheet();
            widgetEndGuildScheduledEventBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", Long.valueOf(guildScheduledEventId)), C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), C12116o.m10073to(WidgetEndGuildScheduledEventBottomSheet.EXTRA_REQUEST_KEY, requestKey)));
            widgetEndGuildScheduledEventBottomSheet.show(fragmentManager, WidgetEndGuildScheduledEventBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$onConfirmEnd$1 */
    /* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
    public static final class C88411 extends AbstractC12240o implements Function1<Unit, Unit> {
        public static final C88411 INSTANCE = new C88411();

        public C88411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            C12238m.checkNotNullParameter(unit, "it");
        }
    }

    public WidgetEndGuildScheduledEventBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEndGuildScheduledEventBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.guildScheduledEventId = C12083g.lazy(new WidgetEndGuildScheduledEventBottomSheet$guildScheduledEventId$2(this));
        this.guildId = C12083g.lazy(new WidgetEndGuildScheduledEventBottomSheet$guildId$2(this));
        this.requestKey = C12083g.lazy(new WidgetEndGuildScheduledEventBottomSheet$requestKey$2(this));
    }

    private final void callOnActionTaken() {
        String requestKey = getRequestKey();
        C12238m.checkNotNullExpressionValue(requestKey, "requestKey");
        FragmentKt.setFragmentResult(this, requestKey, new Bundle());
    }

    private final WidgetEndStageBottomSheetBinding getBinding() {
        return (WidgetEndStageBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildScheduledEventId() {
        return ((Number) this.guildScheduledEventId.getValue()).longValue();
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    private final void onConfirmEnd() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.endEvent(getGuildId(), getGuildScheduledEventId()), false, 1, null), (Class<?>) WidgetEndGuildScheduledEventBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C88411.INSTANCE);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_end_stage_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ScreenTitleView screenTitleView = getBinding().f16601d;
        String string = requireContext().getString(C5419R.string.guild_event_end_prompt_title);
        C12238m.checkNotNullExpressionValue(string, "requireContext().getStri…d_event_end_prompt_title)");
        screenTitleView.setTitle(string);
        getBinding().f16601d.setSubtitle(null);
        MaterialButton materialButton = getBinding().f16599b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.cancel");
        materialButton.setText(requireContext().getString(C5419R.string.guild_event_end_prompt_cancel));
        MaterialButton materialButton2 = getBinding().f16600c;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.confirm");
        materialButton2.setText(requireContext().getString(C5419R.string.guild_event_end_prompt_confirm));
        getBinding().f16599b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEndGuildScheduledEventBottomSheet.this.dismiss();
                WidgetEndGuildScheduledEventBottomSheet.this.callOnActionTaken();
            }
        });
        getBinding().f16600c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEndGuildScheduledEventBottomSheet.this.dismiss();
                WidgetEndGuildScheduledEventBottomSheet.this.onConfirmEnd();
                WidgetEndGuildScheduledEventBottomSheet.this.callOnActionTaken();
            }
        });
    }
}
