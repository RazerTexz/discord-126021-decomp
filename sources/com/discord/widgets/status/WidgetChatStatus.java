package com.discord.widgets.status;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatStatusBinding;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChatStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatStatusBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetChatStatus() {
        super(R$layout.widget_chat_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChatStatus$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatStatus widgetChatStatus, WidgetChatStatus$Model widgetChatStatus$Model) {
        widgetChatStatus.configureUI(widgetChatStatus$Model);
    }

    @MainThread
    private final void configureUI(WidgetChatStatus$Model data) {
        LinearLayout linearLayout = getBinding().f2346b;
        m.checkNotNullExpressionValue(linearLayout, "binding.chatStatusUnreadMessages");
        linearLayout.setVisibility(data.getUnreadVisible() ? 0 : 8);
        getBinding().f2346b.setOnClickListener(new WidgetChatStatus$configureUI$1(data));
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.chatStatusUnreadMessagesText");
        textView.setText(getUnreadMessageText(data.isUnreadEstimate(), data.getUnreadCount(), data.getUnreadMessageId()));
        getBinding().c.setOnClickListener(new WidgetChatStatus$configureUI$2(data));
    }

    private final WidgetChatStatusBinding getBinding() {
        return (WidgetChatStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getUnreadMessageText(boolean isEstimate, int count, long messageId) {
        String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, TimeUtils.parseSnowflake(Long.valueOf(messageId)), requireContext(), 0, 4, null);
        if (isEstimate) {
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            return b.c(resources, 2131893194, new Object[0], new WidgetChatStatus$getUnreadMessageText$1(count, strRenderUtcDate$default));
        }
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources2, requireContext(), R$plurals.new_messages_count, count, Integer.valueOf(count));
        Resources resources3 = getResources();
        m.checkNotNullExpressionValue(resources3, "resources");
        return b.c(resources3, 2131893192, new Object[0], new WidgetChatStatus$getUnreadMessageText$2(quantityString, strRenderUtcDate$default));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetChatStatus$Model.Companion.get(), this, null, 2, null), WidgetChatStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatStatus$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
