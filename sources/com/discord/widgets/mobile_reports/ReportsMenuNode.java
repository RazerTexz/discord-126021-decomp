package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewGroupKt;
import com.discord.C5419R;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeElementData;
import com.discord.databinding.ViewReportsMenuNodeBinding;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.C1019o2;
import p007b.p008a.p025i.C1026p2;
import p007b.p008a.p025i.C1033q2;
import p007b.p008a.p025i.C1040r2;
import p007b.p008a.p025i.C1098z4;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ReportsMenuNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportsMenuNode extends ConstraintLayout {
    private final ViewReportsMenuNodeBinding binding;
    private Function0<Unit> handleBlock;
    private Function0<Unit> handleCancel;
    private Function1<? super ReportNodeBottomButton, Unit> handlePressBottomButton;
    private Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> handleSelectChild;
    private Function0<Unit> handleSubmit;
    private MobileReportsViewModel.NodeState prevViewState;

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupBottomButton$1 */
    /* JADX INFO: compiled from: ReportsMenuNode.kt */
    public static final /* synthetic */ class C90811 extends C12236k implements Function1<ReportNodeBottomButton, Unit> {
        public C90811(ReportsMenuNode reportsMenuNode) {
            super(1, reportsMenuNode, ReportsMenuNode.class, "bottomButtonClickListener", "bottomButtonClickListener(Lcom/discord/api/report/ReportNodeBottomButton;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportNodeBottomButton reportNodeBottomButton) {
            invoke2(reportNodeBottomButton);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportNodeBottomButton reportNodeBottomButton) {
            C12238m.checkNotNullParameter(reportNodeBottomButton, "p1");
            ((ReportsMenuNode) this.receiver).bottomButtonClickListener(reportNodeBottomButton);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingM8401a = ViewReportsMenuNodeBinding.m8401a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(viewReportsMenuNodeBindingM8401a, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingM8401a;
    }

    private final void blockUserClickListener() {
        Function0<Unit> function0 = this.handleBlock;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void bottomButtonClickListener(ReportNodeBottomButton button) {
        Function0<Unit> function0;
        Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2;
        if ((button instanceof ReportNodeBottomButton.Done) || (button instanceof ReportNodeBottomButton.Cancel)) {
            Function0<Unit> function1 = this.handleCancel;
            if (function1 != null) {
                function1.invoke();
                return;
            }
            return;
        }
        if (!(button instanceof ReportNodeBottomButton.Next)) {
            if (!(button instanceof ReportNodeBottomButton.Submit) || (function0 = this.handleSubmit) == null) {
                return;
            }
            function0.invoke();
            return;
        }
        ReportNodeChild reportNodeChild = new ReportNodeChild("", ((ReportNodeBottomButton.Next) button).getTarget());
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (nodeState == null || (function2 = this.handleSelectChild) == null) {
            return;
        }
        function2.invoke(reportNodeChild, nodeState);
    }

    private final void childClickListener(ReportNodeChild destination) {
        Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2;
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (nodeState == null || (function2 = this.handleSelectChild) == null) {
            return;
        }
        function2.invoke(destination, nodeState);
    }

    private final void setupBlockUser(MobileReportsViewModel.NodeState viewState) {
        Context context;
        int i;
        MobileReportsViewModel.BlockUserElement blockUserElement = viewState.getBlockUserElement();
        C1019o2 c1019o2 = this.binding.f15534f;
        C12238m.checkNotNullExpressionValue(c1019o2, "binding.mobileReportsNodeBlockUser");
        LinearLayout linearLayout = c1019o2.f1102a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsNodeBlockUser.root");
        linearLayout.setVisibility(blockUserElement != null ? 0 : 8);
        if (blockUserElement == null) {
            return;
        }
        User user = blockUserElement.getUser();
        boolean zIsBlocked = blockUserElement.isBlocked();
        TextView textView = this.binding.f15534f.f1105d;
        C12238m.checkNotNullExpressionValue(textView, "binding.mobileReportsNod…obileReportsBlockUserName");
        textView.setText(UserUtils.INSTANCE.getUserNameWithDiscriminator(user, Integer.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorHeaderSecondary)), Float.valueOf(0.8f)));
        SimpleDraweeView simpleDraweeView = this.binding.f15534f.f1103b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.mobileReportsNod…ileReportsBlockUserAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, C5419R.dimen.avatar_size_standard, null, null, null, 56, null);
        this.binding.f15534f.f1104c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.mobile_reports.ReportsMenuNode.setupBlockUser.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportsMenuNode.this.blockUserClickListener();
            }
        });
        MaterialButton materialButton = this.binding.f15534f.f1104c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.mobileReportsNod…ileReportsBlockUserButton");
        ViewExtensions.setEnabledAndAlpha(materialButton, !zIsBlocked, 0.5f);
        MaterialButton materialButton2 = this.binding.f15534f.f1104c;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.mobileReportsNod…ileReportsBlockUserButton");
        if (zIsBlocked) {
            context = getContext();
            i = C5419R.string.blocked;
        } else {
            context = getContext();
            i = C5419R.string.block;
        }
        materialButton2.setText(context.getString(i));
    }

    private final void setupBottomButton(MobileReportsViewModel.NodeState viewState) {
        ReportNodeBottomButton bottomButton = viewState.getBottomButton();
        MobileReportsBottomButton mobileReportsBottomButton = this.binding.f15535g;
        C12238m.checkNotNullExpressionValue(mobileReportsBottomButton, "binding.mobileReportsNodeBottomButton");
        mobileReportsBottomButton.setVisibility(bottomButton != null ? 0 : 8);
        this.binding.f15535g.setup(bottomButton, viewState.getSubmitState(), new C90811(this));
    }

    private final void setupBreadCrumbs(MobileReportsViewModel.NodeState viewState) {
        MobileReportsBreadcrumbs mobileReportsBreadcrumbs = this.binding.f15536h;
        C12238m.checkNotNullExpressionValue(mobileReportsBreadcrumbs, "binding.mobileReportsNodeBreadcrumbs");
        mobileReportsBreadcrumbs.setVisibility(viewState.getBreadcrumbsElement() != null ? 0 : 8);
        List<NodeResult> breadcrumbsElement = viewState.getBreadcrumbsElement();
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (!C12238m.areEqual(breadcrumbsElement, nodeState != null ? nodeState.getBreadcrumbsElement() : null)) {
            this.binding.f15536h.setup(viewState.getBreadcrumbsElement());
        }
    }

    private final void setupChannelPreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.ChannelPreview channelPreviewElement = viewState.getChannelPreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        C1026p2 c1026p2 = viewReportsMenuNodeBinding.f15530b;
        if (channelPreviewElement == null) {
            MaterialCardView materialCardView = viewReportsMenuNodeBinding.f15537i;
            C12238m.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeChannelPreview");
            materialCardView.setVisibility(8);
            return;
        }
        TextView textView = c1026p2.f1132c;
        C12238m.checkNotNullExpressionValue(textView, "kicker");
        textView.setText(channelPreviewElement.getStageInstance().getTopic());
        LinkifiedTextView linkifiedTextView = c1026p2.f1133d;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        linkifiedTextView.setText(channelPreviewElement.getGuild().getName());
        c1026p2.f1131b.m8545a(IconUtils.getForGuild$default(channelPreviewElement.getGuild(), null, false, null, 14, null), channelPreviewElement.getGuild().getShortName());
        MaterialCardView materialCardView2 = this.binding.f15537i;
        C12238m.checkNotNullExpressionValue(materialCardView2, "binding.mobileReportsNodeChannelPreview");
        materialCardView2.setVisibility(0);
    }

    private final void setupCheckbox(MobileReportsViewModel.NodeState viewState) {
        List<ReportNodeElementData> data;
        final MobileReportsViewModel.CheckboxElement checkboxElement = viewState.getCheckboxElement();
        LinearLayout linearLayout = this.binding.f15533e;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsMultiselect");
        linearLayout.setVisibility(checkboxElement != null ? 0 : 8);
        MobileReportsViewModel.CheckboxElement checkboxElement2 = viewState.getCheckboxElement();
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (!C12238m.areEqual(checkboxElement2, nodeState != null ? nodeState.getCheckboxElement() : null)) {
            this.binding.f15533e.removeAllViewsInLayout();
            if (checkboxElement == null || (data = checkboxElement.getData()) == null) {
                return;
            }
            for (final ReportNodeElementData reportNodeElementData : data) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
                LinearLayout linearLayout2 = this.binding.f15533e;
                View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.view_mobile_reports_multicheck_item, (ViewGroup) linearLayout2, false);
                linearLayout2.addView(viewInflate);
                Objects.requireNonNull(viewInflate, "rootView");
                CheckedSetting checkedSetting = (CheckedSetting) viewInflate;
                C12238m.checkNotNullExpressionValue(new C1040r2(checkedSetting), "checkbox");
                checkedSetting.setText(reportNodeElementData.getElementValue());
                C12238m.checkNotNullExpressionValue(checkedSetting, "checkbox.root");
                checkedSetting.setChecked(checkboxElement.getSelections().contains(reportNodeElementData));
                checkedSetting.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.mobile_reports.ReportsMenuNode$setupCheckbox$$inlined$forEach$lambda$1
                    @Override // p658rx.functions.Action1
                    public final void call(Boolean bool) {
                        C12238m.checkNotNullExpressionValue(bool, "isChecked");
                        if (bool.booleanValue()) {
                            checkboxElement.getSelections().add(reportNodeElementData);
                        } else {
                            checkboxElement.getSelections().remove(reportNodeElementData);
                        }
                    }
                });
            }
        }
    }

    private final void setupChildren(MobileReportsViewModel.NodeState viewState) {
        ReportNode node;
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (!C12238m.areEqual((nodeState == null || (node = nodeState.getNode()) == null) ? null : node.m8172b(), viewState.getNode().m8172b())) {
            LinearLayout linearLayout = this.binding.f15538j;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsNodeChildList");
            Iterator<View> it = ViewGroupKt.getChildren(linearLayout).iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(null);
            }
            this.binding.f15538j.removeAllViewsInLayout();
            for (final ReportNodeChild reportNodeChild : viewState.getNode().m8172b()) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
                LinearLayout linearLayout2 = this.binding.f15538j;
                View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.view_mobile_reports_child, (ViewGroup) linearLayout2, false);
                linearLayout2.addView(viewInflate);
                int i = C5419R.id.mobile_reports_child;
                CardView cardView = (CardView) viewInflate.findViewById(C5419R.id.mobile_reports_child);
                if (cardView != null) {
                    i = C5419R.id.mobile_reports_child_menu_title;
                    TextView textView = (TextView) viewInflate.findViewById(C5419R.id.mobile_reports_child_menu_title);
                    if (textView != null) {
                        FrameLayout frameLayout = (FrameLayout) viewInflate;
                        C12238m.checkNotNullExpressionValue(new C1033q2(frameLayout, cardView, textView), "childView");
                        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.mobile_reports.ReportsMenuNode$setupChildren$$inlined$forEach$lambda$1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.childClickListener(reportNodeChild);
                            }
                        });
                        C12238m.checkNotNullExpressionValue(textView, "childView.mobileReportsChildMenuTitle");
                        textView.setText(reportNodeChild.getName());
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            }
        }
    }

    private final void setupDirectoryServerPreview(MobileReportsViewModel.NodeState viewState) {
        MaterialCardView materialCardView = this.binding.f15539k;
        C12238m.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeDirectoryChannelPreview");
        materialCardView.setVisibility(viewState.getDirectoryServerPreviewElement() != null ? 0 : 8);
        TextView textView = this.binding.f15540l;
        C12238m.checkNotNullExpressionValue(textView, "binding.mobileReportsNod…ectoryChannelPreviewTitle");
        textView.setVisibility(viewState.getDirectoryServerPreviewElement() != null ? 0 : 8);
        MobileReportsViewModel.DirectoryServerPreview directoryServerPreviewElement = viewState.getDirectoryServerPreviewElement();
        if (directoryServerPreviewElement != null) {
            C1026p2 c1026p2 = this.binding.f15531c;
            LinkifiedTextView linkifiedTextView = c1026p2.f1133d;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            linkifiedTextView.setText(directoryServerPreviewElement.getDirectoryEntry().getGuild().getName());
            TextView textView2 = c1026p2.f1132c;
            C12238m.checkNotNullExpressionValue(textView2, "kicker");
            textView2.setText(directoryServerPreviewElement.getHub().getName());
            c1026p2.f1131b.m8545a(IconUtils.getForGuild$default(Long.valueOf(directoryServerPreviewElement.getDirectoryEntry().getGuild().getId()), directoryServerPreviewElement.getDirectoryEntry().getGuild().getIcon(), null, false, null, 28, null), GuildUtilsKt.computeShortName(directoryServerPreviewElement.getDirectoryEntry().getGuild().getName()));
        }
    }

    private final void setupEventPreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.GuildScheduledEventPreview eventPreviewElement = viewState.getEventPreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        C1026p2 c1026p2 = viewReportsMenuNodeBinding.f15530b;
        if (eventPreviewElement == null) {
            MaterialCardView materialCardView = viewReportsMenuNodeBinding.f15537i;
            C12238m.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeChannelPreview");
            materialCardView.setVisibility(8);
            return;
        }
        TextView textView = c1026p2.f1132c;
        C12238m.checkNotNullExpressionValue(textView, "kicker");
        textView.setText(eventPreviewElement.getGuild().getName());
        LinkifiedTextView linkifiedTextView = c1026p2.f1133d;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        linkifiedTextView.setText(eventPreviewElement.getEvent().getName());
        c1026p2.f1131b.m8545a(IconUtils.getForGuild$default(eventPreviewElement.getGuild(), null, false, null, 14, null), eventPreviewElement.getGuild().getShortName());
        MaterialCardView materialCardView2 = this.binding.f15537i;
        C12238m.checkNotNullExpressionValue(materialCardView2, "binding.mobileReportsNodeChannelPreview");
        materialCardView2.setVisibility(0);
    }

    private final void setupMessagePreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.MessagePreview messagePreviewElement = viewState.getMessagePreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        if (messagePreviewElement == null) {
            C1098z4 c1098z4 = viewReportsMenuNodeBinding.f15532d;
            C12238m.checkNotNullExpressionValue(c1098z4, "mobileReportsMessagePreview");
            ConstraintLayout constraintLayout = c1098z4.f1444a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "mobileReportsMessagePreview.root");
            constraintLayout.setVisibility(8);
            return;
        }
        TextView textView = viewReportsMenuNodeBinding.f15532d.f1448e;
        C12238m.checkNotNullExpressionValue(textView, "mobileReportsMessagePrev…atListAdapterItemTextName");
        textView.setText(messagePreviewElement.getAuthorName());
        viewReportsMenuNodeBinding.f15532d.f1448e.setTextColor(messagePreviewElement.getAuthorNameColor());
        SimpleDraweeView simpleDraweeView = viewReportsMenuNodeBinding.f15532d.f1447d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "mobileReportsMessagePrev…ListAdapterItemTextAvatar");
        IconUtils.setIcon$default(simpleDraweeView, messagePreviewElement.getAuthor(), C5419R.dimen.avatar_size_small, null, null, null, 56, null);
        viewReportsMenuNodeBinding.f15532d.f1446c.setDraweeSpanStringBuilder(messagePreviewElement.getText());
        ImageView imageView = viewReportsMenuNodeBinding.f15532d.f1445b;
        C12238m.checkNotNullExpressionValue(imageView, "mobileReportsMessagePrev…terItemChatAttachmentIcon");
        imageView.setVisibility(messagePreviewElement.getHasEmbeds() ? 0 : 8);
        C1098z4 c1098z5 = viewReportsMenuNodeBinding.f15532d;
        C12238m.checkNotNullExpressionValue(c1098z5, "mobileReportsMessagePreview");
        ConstraintLayout constraintLayout2 = c1098z5.f1444a;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "mobileReportsMessagePreview.root");
        constraintLayout2.setVisibility(0);
    }

    private final void setupSuccess(boolean showSuccess) {
        ImageView imageView = this.binding.f15545q;
        C12238m.checkNotNullExpressionValue(imageView, "binding.mobileReportsNodeSuccessShield");
        imageView.setVisibility(showSuccess ? 0 : 8);
    }

    private final void setupTextElements(MobileReportsViewModel.NodeState viewState) {
        TextView textView = this.binding.f15541m;
        C12238m.checkNotNullExpressionValue(textView, "binding.mobileReportsNodeHeader");
        textView.setText(C1107b.m215g(viewState.getNode().getHeader(), new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null));
        String subheader = viewState.getNode().getSubheader();
        LinkifiedTextView linkifiedTextView = this.binding.f15544p;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.mobileReportsNodeSubheader");
        linkifiedTextView.setVisibility(subheader != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = this.binding.f15544p;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.mobileReportsNodeSubheader");
        C1107b.m223o(linkifiedTextView2, subheader, new Object[0], null, 4);
        String info = viewState.getNode().getInfo();
        MaterialCardView materialCardView = this.binding.f15542n;
        C12238m.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeInfoBox");
        materialCardView.setVisibility(info != null ? 0 : 8);
        TextView textView2 = this.binding.f15543o;
        C12238m.checkNotNullExpressionValue(textView2, "binding.mobileReportsNodeInfoText");
        C1107b.m223o(textView2, info, new Object[0], null, 4);
    }

    public final Function0<Unit> getHandleBlock() {
        return this.handleBlock;
    }

    public final Function0<Unit> getHandleCancel() {
        return this.handleCancel;
    }

    public final Function1<ReportNodeBottomButton, Unit> getHandlePressBottomButton() {
        return this.handlePressBottomButton;
    }

    public final Function2<ReportNodeChild, MobileReportsViewModel.NodeState, Unit> getHandleSelectChild() {
        return this.handleSelectChild;
    }

    public final Function0<Unit> getHandleSubmit() {
        return this.handleSubmit;
    }

    /* JADX INFO: renamed from: getViewState, reason: from getter */
    public final MobileReportsViewModel.NodeState getPrevViewState() {
        return this.prevViewState;
    }

    public final void setHandleBlock(Function0<Unit> function0) {
        this.handleBlock = function0;
    }

    public final void setHandleCancel(Function0<Unit> function0) {
        this.handleCancel = function0;
    }

    public final void setHandlePressBottomButton(Function1<? super ReportNodeBottomButton, Unit> function1) {
        this.handlePressBottomButton = function1;
    }

    public final void setHandleSelectChild(Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2) {
        this.handleSelectChild = function2;
    }

    public final void setHandleSubmit(Function0<Unit> function0) {
        this.handleSubmit = function0;
    }

    public final void setup(MobileReportsViewModel.NodeState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        setupSuccess(viewState.getSuccessElement());
        setupMessagePreview(viewState);
        setupChannelPreview(viewState);
        setupDirectoryServerPreview(viewState);
        setupEventPreview(viewState);
        setupBreadCrumbs(viewState);
        setupTextElements(viewState);
        setupChildren(viewState);
        setupCheckbox(viewState);
        setupBottomButton(viewState);
        setupBlockUser(viewState);
        this.prevViewState = viewState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingM8401a = ViewReportsMenuNodeBinding.m8401a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(viewReportsMenuNodeBindingM8401a, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingM8401a;
    }

    public /* synthetic */ ReportsMenuNode(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public /* synthetic */ ReportsMenuNode(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingM8401a = ViewReportsMenuNodeBinding.m8401a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(viewReportsMenuNodeBindingM8401a, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingM8401a;
    }
}
