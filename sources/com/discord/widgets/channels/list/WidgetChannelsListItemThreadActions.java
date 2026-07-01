package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelsListItemThreadActionsBinding;
import com.discord.restapi.RestAPIParams$ThreadSettings;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelsListItemThreadActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", 0)};
    public static final WidgetChannelsListItemThreadActions$Companion Companion = new WidgetChannelsListItemThreadActions$Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetChannelsListItemThreadActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelsListItemThreadActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model) {
        widgetChannelsListItemThreadActions.configureUI(widgetChannelsListItemThreadActions$Model);
    }

    public static final /* synthetic */ void access$leaveThread(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, Channel channel) {
        widgetChannelsListItemThreadActions.leaveThread(channel);
    }

    public static final /* synthetic */ void access$unarchiveThread(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, Channel channel, boolean z2) {
        widgetChannelsListItemThreadActions.unarchiveThread(channel, z2);
    }

    private final void configureUI(WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model) {
        ThreadMetadata threadMetadata;
        ThreadMetadata threadMetadata2;
        if (widgetChannelsListItemThreadActions$Model == null) {
            dismiss();
            return;
        }
        if (widgetChannelsListItemThreadActions$Model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().i;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, widgetChannelsListItemThreadActions$Model.getGuild(), 0, (MGImages$ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().i;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemThreadActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, widgetChannelsListItemThreadActions$Model.getChannel(), 0, (MGImages$ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().m;
        m.checkNotNullExpressionValue(textView, "binding.channelsListItemThreadActionsTitle");
        Channel channel = widgetChannelsListItemThreadActions$Model.getChannel();
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.e(channel, contextRequireContext, false, 2));
        TextView textView2 = getBinding().k;
        m.checkNotNullExpressionValue(textView2, "binding.channelsListItemThreadActionsMarkAsRead");
        setOnClickAndDismissListener(textView2, new WidgetChannelsListItemThreadActions$configureUI$1(widgetChannelsListItemThreadActions$Model));
        TextView textView3 = getBinding().l;
        m.checkNotNullExpressionValue(textView3, "binding.channelsListItemThreadActionsMute");
        Channel channel2 = widgetChannelsListItemThreadActions$Model.getChannel();
        boolean zIsMuted = widgetChannelsListItemThreadActions$Model.isMuted();
        Context contextRequireContext2 = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        textView3.setText(getMuteThreadText(channel2, zIsMuted, contextRequireContext2));
        TextView textView4 = getBinding().l;
        boolean zIsMuted2 = widgetChannelsListItemThreadActions$Model.isMuted();
        Context contextRequireContext3 = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
        textView4.setCompoundDrawablesWithIntrinsicBounds(getMuteIconResId(zIsMuted2, contextRequireContext3), 0, 0, 0);
        TextView textView5 = getBinding().l;
        m.checkNotNullExpressionValue(textView5, "binding.channelsListItemThreadActionsMute");
        setOnClickAndDismissListener(textView5, new WidgetChannelsListItemThreadActions$configureUI$2(this, widgetChannelsListItemThreadActions$Model));
        getBinding().d.setOnClickListener(new WidgetChannelsListItemThreadActions$configureUI$3(this, widgetChannelsListItemThreadActions$Model));
        View view = getBinding().g;
        m.checkNotNullExpressionValue(view, "binding.channelsListItemThreadActionsDivider");
        view.setVisibility(widgetChannelsListItemThreadActions$Model.isActiveThread() ? 0 : 8);
        TextView textView6 = getBinding().h;
        m.checkNotNullExpressionValue(textView6, "binding.channelsListItemThreadActionsEdit");
        textView6.setVisibility(widgetChannelsListItemThreadActions$Model.getCanManageThread() ? 0 : 8);
        TextView textView7 = getBinding().h;
        m.checkNotNullExpressionValue(textView7, "binding.channelsListItemThreadActionsEdit");
        setOnClickAndDismissListener(textView7, new WidgetChannelsListItemThreadActions$configureUI$4(widgetChannelsListItemThreadActions$Model));
        boolean z2 = widgetChannelsListItemThreadActions$Model.getCanManageThread() && ((threadMetadata2 = widgetChannelsListItemThreadActions$Model.getChannel().getThreadMetadata()) == null || !threadMetadata2.getArchived());
        LinearLayout linearLayout = getBinding().f2297b;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelsListItem…eadActionsArchiveSettings");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            Context contextRequireContext4 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
            ThreadMetadata threadMetadata3 = widgetChannelsListItemThreadActions$Model.getChannel().getThreadMetadata();
            m.checkNotNull(threadMetadata3);
            String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(contextRequireContext4, threadMetadata3.getAutoArchiveDuration());
            TextView textView8 = getBinding().c;
            m.checkNotNullExpressionValue(textView8, "binding.channelsListItem…sArchiveSettingsSubheader");
            Locale locale = Locale.getDefault();
            m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            textView8.setText(b.k(this, 2131886939, new Object[]{lowerCase}, null, 4));
        }
        LinearLayout linearLayout2 = getBinding().f2297b;
        m.checkNotNullExpressionValue(linearLayout2, "binding.channelsListItem…eadActionsArchiveSettings");
        setOnClickAndDismissListener(linearLayout2, new WidgetChannelsListItemThreadActions$configureUI$5(this, widgetChannelsListItemThreadActions$Model));
        TextView textView9 = getBinding().n;
        m.checkNotNullExpressionValue(textView9, "binding.channelsListItemThreadActionsUnarchive");
        textView9.setVisibility(widgetChannelsListItemThreadActions$Model.getCanUnarchiveThread() && (threadMetadata = widgetChannelsListItemThreadActions$Model.getChannel().getThreadMetadata()) != null && threadMetadata.getArchived() ? 0 : 8);
        getBinding().n.setOnClickListener(new WidgetChannelsListItemThreadActions$configureUI$6(this, widgetChannelsListItemThreadActions$Model));
        TextView textView10 = getBinding().j;
        m.checkNotNullExpressionValue(textView10, "binding.channelsListItemThreadActionsLeave");
        textView10.setVisibility(widgetChannelsListItemThreadActions$Model.getJoinedThread() != null ? 0 : 8);
        getBinding().j.setOnClickListener(new WidgetChannelsListItemThreadActions$configureUI$7(this, widgetChannelsListItemThreadActions$Model));
        View view2 = getBinding().f;
        m.checkNotNullExpressionValue(view2, "binding.channelsListItem…adActionsDeveloperDivider");
        view2.setVisibility(widgetChannelsListItemThreadActions$Model.getIsDeveloper() ? 0 : 8);
        TextView textView11 = getBinding().e;
        m.checkNotNullExpressionValue(textView11, "binding.channelsListItemThreadActionsCopyId");
        textView11.setVisibility(widgetChannelsListItemThreadActions$Model.getIsDeveloper() ? 0 : 8);
        TextView textView12 = getBinding().e;
        m.checkNotNullExpressionValue(textView12, "binding.channelsListItemThreadActionsCopyId");
        setOnClickAndDismissListener(textView12, new WidgetChannelsListItemThreadActions$configureUI$8(widgetChannelsListItemThreadActions$Model));
    }

    private final WidgetChannelsListItemThreadActionsBinding getBinding() {
        return (WidgetChannelsListItemThreadActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getMuteIconResId(boolean isMuted, Context context) {
        return DrawableCompat.getThemedDrawableRes$default(context, isMuted ? 2130969476 : 2130969475, 0, 2, (Object) null);
    }

    private final CharSequence getMuteThreadText(Channel channel, boolean isMuted, Context context) {
        return isMuted ? b.h(context, 2131896587, new Object[0], null, 4) : b.h(context, 2131893139, new Object[]{ChannelUtils.e(channel, context, false, 2)}, null, 4);
    }

    private final void leaveThread(Channel channel) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().leaveThread(channel.getId(), "Context Menu"), false, 1, null), this, null, 2, null), getContext(), "REST: leaveThread", (Function1) null, new WidgetChannelsListItemThreadActions$leaveThread$1(this), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        Companion.show(fragmentManager, j);
    }

    private final void unarchiveThread(Channel channel, boolean unlockThread) {
        RestAPI api = RestAPI.Companion.getApi();
        long id2 = channel.getId();
        Boolean bool = Boolean.FALSE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams$ThreadSettings(bool, unlockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), getContext(), "REST: unarchiveThread", (Function1) null, new WidgetChannelsListItemThreadActions$unarchiveThread$2(this), new WidgetChannelsListItemThreadActions$unarchiveThread$1(this), (Function0) null, (Function0) null, 100, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetChannelsListItemThreadActions$Model.Companion.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetChannelsListItemThreadActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelsListItemThreadActions$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_channels_list_item_thread_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
