package com.discord.widgets.forums;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetForumGuidelinesBottomSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetForumGuidelinesBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REQUEST_KEY = "INTENT_EXTRA_REQUEST_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;

    /* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function2<? super Long, ? super Long, Unit> onActionTaken) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            C12238m.checkNotNullParameter(onActionTaken, "onActionTaken");
            FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetForumGuidelinesBottomSheet$Companion$registerForResult$1(requestKey, onActionTaken));
        }

        public final void show(FragmentManager fragmentManager, long guildId, long parentChannelId, String requestKey) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            ForumGuidelinesManager.INSTANCE.markGuidelinesSeen(parentChannelId);
            WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet = new WidgetForumGuidelinesBottomSheet();
            widgetForumGuidelinesBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(parentChannelId)), C12116o.m10073to(WidgetForumGuidelinesBottomSheet.EXTRA_REQUEST_KEY, requestKey)));
            widgetForumGuidelinesBottomSheet.show(fragmentManager, WidgetForumGuidelinesBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
    public static final class C83541 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C83541() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            WidgetForumGuidelinesBottomSheet.this.configureUI(channel);
        }
    }

    public WidgetForumGuidelinesBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetForumGuidelinesBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetForumGuidelinesBottomSheet$guildId$2(this));
        this.channelId = C12083g.lazy(new WidgetForumGuidelinesBottomSheet$channelId$2(this));
        this.requestKey = C12083g.lazy(new WidgetForumGuidelinesBottomSheet$requestKey$2(this));
    }

    private final void configureUI(Channel channel) {
        TextView textView = getBinding().f16641b;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelTopic");
        textView.setText(channel.getTopic());
        final Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", getChannelId());
        bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", getGuildId());
        getBinding().f16642c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetForumGuidelinesBottomSheet.this.dismiss();
                WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet = WidgetForumGuidelinesBottomSheet.this;
                String requestKey = widgetForumGuidelinesBottomSheet.getRequestKey();
                C12238m.checkNotNullExpressionValue(requestKey, "requestKey");
                FragmentKt.setFragmentResult(widgetForumGuidelinesBottomSheet, requestKey, bundle);
            }
        });
    }

    private final WidgetForumGuidelinesBottomSheetBinding getBinding() {
        return (WidgetForumGuidelinesBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_forum_guidelines_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<R> observableM11083G = StoreStream.INSTANCE.getChannels().observeChannel(getChannelId()).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11083G, this, null, 2, null), (Class<?>) WidgetForumGuidelinesBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83541());
    }
}
