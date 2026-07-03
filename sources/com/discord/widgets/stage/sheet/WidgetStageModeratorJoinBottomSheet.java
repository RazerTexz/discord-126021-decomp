package com.discord.widgets.stage.sheet;

import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageModeratorJoinBottomSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageModeratorJoinBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetStageModeratorJoinBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageModeratorJoinBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet = new WidgetStageModeratorJoinBottomSheet();
            widgetStageModeratorJoinBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetStageModeratorJoinBottomSheet.show(fragmentManager, WidgetStageModeratorJoinBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$setSelfSpeaker$1 */
    /* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
    public static final class C100291 extends AbstractC12240o implements Function1<Void, Unit> {
        public C100291() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetStageModeratorJoinBottomSheet.this.dismiss();
        }
    }

    public WidgetStageModeratorJoinBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageModeratorJoinBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetStageModeratorJoinBottomSheet$channelId$2(this));
    }

    private final WidgetStageModeratorJoinBottomSheetBinding getBinding() {
        return (WidgetStageModeratorJoinBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final void setSelfSpeaker() {
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(getChannelId());
        if (channel != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, false), false, 1, null), this, null, 2, null), (Class<?>) WidgetStageModeratorJoinBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100291());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_stage_moderator_join_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f18164c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet.onViewCreated.1

            /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$onViewCreated$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C0876m.m169g(WidgetStageModeratorJoinBottomSheet.this.getContext(), C5419R.string.stage_channel_permission_microphone_denied, 0, null, 12);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$onViewCreated$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetStageModeratorJoinBottomSheet.this.setSelfSpeaker();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetStageModeratorJoinBottomSheet.this.requestMicrophone(new AnonymousClass1(), new AnonymousClass2());
            }
        });
        getBinding().f18163b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetStageModeratorJoinBottomSheet.this.dismiss();
            }
        });
    }
}
