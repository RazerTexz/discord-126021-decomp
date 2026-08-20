package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$2 */
/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7454x3de54559 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetChannelsListItemChannelActions.Model $this_configureUI$inlined;
    public final /* synthetic */ WidgetChannelsListItemChannelActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7454x3de54559(TextView textView, WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, WidgetChannelsListItemChannelActions.Model model) {
        super(1);
        this.$this_apply = textView;
        this.this$0 = widgetChannelsListItemChannelActions;
        this.$this_configureUI$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
        Context context = this.$this_apply.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(context, parentFragmentManager, this.$this_configureUI$inlined.getChannel().getGuildId(), (16 & 8) != 0 ? null : Long.valueOf(this.$this_configureUI$inlined.getChannel().getId()), (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Context Menu");
    }
}
