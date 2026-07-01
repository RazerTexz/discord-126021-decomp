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
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.view.ViewGroupKt;
import b.a.i.o2;
import b.a.i.p2;
import b.a.i.q2;
import b.a.i.r2;
import b.a.i.z4;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeBottomButton$Cancel;
import com.discord.api.report.ReportNodeBottomButton$Done;
import com.discord.api.report.ReportNodeBottomButton$Next;
import com.discord.api.report.ReportNodeBottomButton$Submit;
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
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ReportsMenuNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportsMenuNode extends ConstraintLayout {
    private final ViewReportsMenuNodeBinding binding;
    private Function0<Unit> handleBlock;
    private Function0<Unit> handleCancel;
    private Function1<? super ReportNodeBottomButton, Unit> handlePressBottomButton;
    private Function2<? super ReportNodeChild, ? super MobileReportsViewModel$NodeState, Unit> handleSelectChild;
    private Function0<Unit> handleSubmit;
    private MobileReportsViewModel$NodeState prevViewState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingA = ViewReportsMenuNodeBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewReportsMenuNodeBindingA, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingA;
    }

    public static final /* synthetic */ void access$blockUserClickListener(ReportsMenuNode reportsMenuNode) {
        reportsMenuNode.blockUserClickListener();
    }

    public static final /* synthetic */ void access$bottomButtonClickListener(ReportsMenuNode reportsMenuNode, ReportNodeBottomButton reportNodeBottomButton) {
        reportsMenuNode.bottomButtonClickListener(reportNodeBottomButton);
    }

    public static final /* synthetic */ void access$childClickListener(ReportsMenuNode reportsMenuNode, ReportNodeChild reportNodeChild) {
        reportsMenuNode.childClickListener(reportNodeChild);
    }

    private final void blockUserClickListener() {
        Function0<Unit> function0 = this.handleBlock;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void bottomButtonClickListener(ReportNodeBottomButton button) {
        Function0<Unit> function0;
        Function2<? super ReportNodeChild, ? super MobileReportsViewModel$NodeState, Unit> function2;
        if ((button instanceof ReportNodeBottomButton$Done) || (button instanceof ReportNodeBottomButton$Cancel)) {
            Function0<Unit> function1 = this.handleCancel;
            if (function1 != null) {
                function1.invoke();
                return;
            }
            return;
        }
        if (!(button instanceof ReportNodeBottomButton$Next)) {
            if (!(button instanceof ReportNodeBottomButton$Submit) || (function0 = this.handleSubmit) == null) {
                return;
            }
            function0.invoke();
            return;
        }
        ReportNodeChild reportNodeChild = new ReportNodeChild("", ((ReportNodeBottomButton$Next) button).getTarget());
        MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState = this.prevViewState;
        if (mobileReportsViewModel$NodeState == null || (function2 = this.handleSelectChild) == null) {
            return;
        }
        function2.invoke(reportNodeChild, mobileReportsViewModel$NodeState);
    }

    private final void childClickListener(ReportNodeChild destination) {
        Function2<? super ReportNodeChild, ? super MobileReportsViewModel$NodeState, Unit> function2;
        MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState = this.prevViewState;
        if (mobileReportsViewModel$NodeState == null || (function2 = this.handleSelectChild) == null) {
            return;
        }
        function2.invoke(destination, mobileReportsViewModel$NodeState);
    }

    private final void setupBlockUser(MobileReportsViewModel$NodeState viewState) {
        Context context;
        int i;
        MobileReportsViewModel$BlockUserElement blockUserElement = viewState.getBlockUserElement();
        o2 o2Var = this.binding.f;
        m.checkNotNullExpressionValue(o2Var, "binding.mobileReportsNodeBlockUser");
        LinearLayout linearLayout = o2Var.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsNodeBlockUser.root");
        linearLayout.setVisibility(blockUserElement != null ? 0 : 8);
        if (blockUserElement == null) {
            return;
        }
        User user = blockUserElement.getUser();
        boolean zIsBlocked = blockUserElement.isBlocked();
        TextView textView = this.binding.f.d;
        m.checkNotNullExpressionValue(textView, "binding.mobileReportsNod…obileReportsBlockUserName");
        textView.setText(UserUtils.INSTANCE.getUserNameWithDiscriminator(user, Integer.valueOf(ColorCompat.getThemedColor(getContext(), 2130968990)), Float.valueOf(0.8f)));
        SimpleDraweeView simpleDraweeView = this.binding.f.f173b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.mobileReportsNod…ileReportsBlockUserAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, 2131165300, null, null, null, 56, null);
        this.binding.f.c.setOnClickListener(new ReportsMenuNode$setupBlockUser$1(this));
        MaterialButton materialButton = this.binding.f.c;
        m.checkNotNullExpressionValue(materialButton, "binding.mobileReportsNod…ileReportsBlockUserButton");
        ViewExtensions.setEnabledAndAlpha(materialButton, !zIsBlocked, 0.5f);
        MaterialButton materialButton2 = this.binding.f.c;
        m.checkNotNullExpressionValue(materialButton2, "binding.mobileReportsNod…ileReportsBlockUserButton");
        if (zIsBlocked) {
            context = getContext();
            i = 2131887260;
        } else {
            context = getContext();
            i = 2131887257;
        }
        materialButton2.setText(context.getString(i));
    }

    private final void setupBottomButton(MobileReportsViewModel$NodeState viewState) {
        ReportNodeBottomButton bottomButton = viewState.getBottomButton();
        MobileReportsBottomButton mobileReportsBottomButton = this.binding.g;
        m.checkNotNullExpressionValue(mobileReportsBottomButton, "binding.mobileReportsNodeBottomButton");
        mobileReportsBottomButton.setVisibility(bottomButton != null ? 0 : 8);
        this.binding.g.setup(bottomButton, viewState.getSubmitState(), new ReportsMenuNode$setupBottomButton$1(this));
    }

    private final void setupBreadCrumbs(MobileReportsViewModel$NodeState viewState) {
        MobileReportsBreadcrumbs mobileReportsBreadcrumbs = this.binding.h;
        m.checkNotNullExpressionValue(mobileReportsBreadcrumbs, "binding.mobileReportsNodeBreadcrumbs");
        mobileReportsBreadcrumbs.setVisibility(viewState.getBreadcrumbsElement() != null ? 0 : 8);
        List<NodeResult> breadcrumbsElement = viewState.getBreadcrumbsElement();
        MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState = this.prevViewState;
        if (!m.areEqual(breadcrumbsElement, mobileReportsViewModel$NodeState != null ? mobileReportsViewModel$NodeState.getBreadcrumbsElement() : null)) {
            this.binding.h.setup(viewState.getBreadcrumbsElement());
        }
    }

    private final void setupChannelPreview(MobileReportsViewModel$NodeState viewState) {
        MobileReportsViewModel$ChannelPreview channelPreviewElement = viewState.getChannelPreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        p2 p2Var = viewReportsMenuNodeBinding.f2206b;
        if (channelPreviewElement == null) {
            MaterialCardView materialCardView = viewReportsMenuNodeBinding.i;
            m.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeChannelPreview");
            materialCardView.setVisibility(8);
            return;
        }
        TextView textView = p2Var.c;
        m.checkNotNullExpressionValue(textView, "kicker");
        textView.setText(channelPreviewElement.getStageInstance().getTopic());
        LinkifiedTextView linkifiedTextView = p2Var.d;
        m.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        linkifiedTextView.setText(channelPreviewElement.getGuild().getName());
        p2Var.f179b.a(IconUtils.getForGuild$default(channelPreviewElement.getGuild(), null, false, null, 14, null), channelPreviewElement.getGuild().getShortName());
        MaterialCardView materialCardView2 = this.binding.i;
        m.checkNotNullExpressionValue(materialCardView2, "binding.mobileReportsNodeChannelPreview");
        materialCardView2.setVisibility(0);
    }

    private final void setupCheckbox(MobileReportsViewModel$NodeState viewState) {
        List<ReportNodeElementData> data;
        MobileReportsViewModel$CheckboxElement checkboxElement = viewState.getCheckboxElement();
        LinearLayout linearLayout = this.binding.e;
        m.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsMultiselect");
        linearLayout.setVisibility(checkboxElement != null ? 0 : 8);
        MobileReportsViewModel$CheckboxElement checkboxElement2 = viewState.getCheckboxElement();
        MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState = this.prevViewState;
        if (!m.areEqual(checkboxElement2, mobileReportsViewModel$NodeState != null ? mobileReportsViewModel$NodeState.getCheckboxElement() : null)) {
            this.binding.e.removeAllViewsInLayout();
            if (checkboxElement == null || (data = checkboxElement.getData()) == null) {
                return;
            }
            for (ReportNodeElementData reportNodeElementData : data) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
                LinearLayout linearLayout2 = this.binding.e;
                View viewInflate = layoutInflaterFrom.inflate(R$layout.view_mobile_reports_multicheck_item, (ViewGroup) linearLayout2, false);
                linearLayout2.addView(viewInflate);
                Objects.requireNonNull(viewInflate, "rootView");
                CheckedSetting checkedSetting = (CheckedSetting) viewInflate;
                m.checkNotNullExpressionValue(new r2(checkedSetting), "checkbox");
                checkedSetting.setText(reportNodeElementData.getElementValue());
                m.checkNotNullExpressionValue(checkedSetting, "checkbox.root");
                checkedSetting.setChecked(checkboxElement.getSelections().contains(reportNodeElementData));
                checkedSetting.setOnCheckedListener(new ReportsMenuNode$setupCheckbox$$inlined$forEach$lambda$1(reportNodeElementData, this, checkboxElement));
            }
        }
    }

    private final void setupChildren(MobileReportsViewModel$NodeState viewState) {
        ReportNode node;
        MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState = this.prevViewState;
        if (!m.areEqual((mobileReportsViewModel$NodeState == null || (node = mobileReportsViewModel$NodeState.getNode()) == null) ? null : node.b(), viewState.getNode().b())) {
            LinearLayout linearLayout = this.binding.j;
            m.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsNodeChildList");
            Iterator<View> it = ViewGroupKt.getChildren(linearLayout).iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(null);
            }
            this.binding.j.removeAllViewsInLayout();
            for (ReportNodeChild reportNodeChild : viewState.getNode().b()) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
                LinearLayout linearLayout2 = this.binding.j;
                View viewInflate = layoutInflaterFrom.inflate(R$layout.view_mobile_reports_child, (ViewGroup) linearLayout2, false);
                linearLayout2.addView(viewInflate);
                int i = R$id.mobile_reports_child;
                CardView cardView = (CardView) viewInflate.findViewById(R$id.mobile_reports_child);
                if (cardView != null) {
                    i = R$id.mobile_reports_child_menu_title;
                    TextView textView = (TextView) viewInflate.findViewById(R$id.mobile_reports_child_menu_title);
                    if (textView != null) {
                        FrameLayout frameLayout = (FrameLayout) viewInflate;
                        m.checkNotNullExpressionValue(new q2(frameLayout, cardView, textView), "childView");
                        frameLayout.setOnClickListener(new ReportsMenuNode$setupChildren$$inlined$forEach$lambda$1(reportNodeChild, this));
                        m.checkNotNullExpressionValue(textView, "childView.mobileReportsChildMenuTitle");
                        textView.setText(reportNodeChild.getName());
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            }
        }
    }

    private final void setupDirectoryServerPreview(MobileReportsViewModel$NodeState viewState) {
        MaterialCardView materialCardView = this.binding.k;
        m.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeDirectoryChannelPreview");
        materialCardView.setVisibility(viewState.getDirectoryServerPreviewElement() != null ? 0 : 8);
        TextView textView = this.binding.l;
        m.checkNotNullExpressionValue(textView, "binding.mobileReportsNod…ectoryChannelPreviewTitle");
        textView.setVisibility(viewState.getDirectoryServerPreviewElement() != null ? 0 : 8);
        MobileReportsViewModel$DirectoryServerPreview directoryServerPreviewElement = viewState.getDirectoryServerPreviewElement();
        if (directoryServerPreviewElement != null) {
            p2 p2Var = this.binding.c;
            LinkifiedTextView linkifiedTextView = p2Var.d;
            m.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
            linkifiedTextView.setText(directoryServerPreviewElement.getDirectoryEntry().getGuild().getName());
            TextView textView2 = p2Var.c;
            m.checkNotNullExpressionValue(textView2, "kicker");
            textView2.setText(directoryServerPreviewElement.getHub().getName());
            p2Var.f179b.a(IconUtils.getForGuild$default(Long.valueOf(directoryServerPreviewElement.getDirectoryEntry().getGuild().getId()), directoryServerPreviewElement.getDirectoryEntry().getGuild().getIcon(), null, false, null, 28, null), GuildUtilsKt.computeShortName(directoryServerPreviewElement.getDirectoryEntry().getGuild().getName()));
        }
    }

    private final void setupEventPreview(MobileReportsViewModel$NodeState viewState) {
        MobileReportsViewModel$GuildScheduledEventPreview eventPreviewElement = viewState.getEventPreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        p2 p2Var = viewReportsMenuNodeBinding.f2206b;
        if (eventPreviewElement == null) {
            MaterialCardView materialCardView = viewReportsMenuNodeBinding.i;
            m.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeChannelPreview");
            materialCardView.setVisibility(8);
            return;
        }
        TextView textView = p2Var.c;
        m.checkNotNullExpressionValue(textView, "kicker");
        textView.setText(eventPreviewElement.getGuild().getName());
        LinkifiedTextView linkifiedTextView = p2Var.d;
        m.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        linkifiedTextView.setText(eventPreviewElement.getEvent().getName());
        p2Var.f179b.a(IconUtils.getForGuild$default(eventPreviewElement.getGuild(), null, false, null, 14, null), eventPreviewElement.getGuild().getShortName());
        MaterialCardView materialCardView2 = this.binding.i;
        m.checkNotNullExpressionValue(materialCardView2, "binding.mobileReportsNodeChannelPreview");
        materialCardView2.setVisibility(0);
    }

    private final void setupMessagePreview(MobileReportsViewModel$NodeState viewState) {
        MobileReportsViewModel$MessagePreview messagePreviewElement = viewState.getMessagePreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        if (messagePreviewElement == null) {
            z4 z4Var = viewReportsMenuNodeBinding.d;
            m.checkNotNullExpressionValue(z4Var, "mobileReportsMessagePreview");
            ConstraintLayout constraintLayout = z4Var.a;
            m.checkNotNullExpressionValue(constraintLayout, "mobileReportsMessagePreview.root");
            constraintLayout.setVisibility(8);
            return;
        }
        TextView textView = viewReportsMenuNodeBinding.d.e;
        m.checkNotNullExpressionValue(textView, "mobileReportsMessagePrev…atListAdapterItemTextName");
        textView.setText(messagePreviewElement.getAuthorName());
        viewReportsMenuNodeBinding.d.e.setTextColor(messagePreviewElement.getAuthorNameColor());
        SimpleDraweeView simpleDraweeView = viewReportsMenuNodeBinding.d.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "mobileReportsMessagePrev…ListAdapterItemTextAvatar");
        IconUtils.setIcon$default(simpleDraweeView, messagePreviewElement.getAuthor(), 2131165299, null, null, null, 56, null);
        viewReportsMenuNodeBinding.d.c.setDraweeSpanStringBuilder(messagePreviewElement.getText());
        ImageView imageView = viewReportsMenuNodeBinding.d.f241b;
        m.checkNotNullExpressionValue(imageView, "mobileReportsMessagePrev…terItemChatAttachmentIcon");
        imageView.setVisibility(messagePreviewElement.getHasEmbeds() ? 0 : 8);
        z4 z4Var2 = viewReportsMenuNodeBinding.d;
        m.checkNotNullExpressionValue(z4Var2, "mobileReportsMessagePreview");
        ConstraintLayout constraintLayout2 = z4Var2.a;
        m.checkNotNullExpressionValue(constraintLayout2, "mobileReportsMessagePreview.root");
        constraintLayout2.setVisibility(0);
    }

    private final void setupSuccess(boolean showSuccess) {
        ImageView imageView = this.binding.q;
        m.checkNotNullExpressionValue(imageView, "binding.mobileReportsNodeSuccessShield");
        imageView.setVisibility(showSuccess ? 0 : 8);
    }

    private final void setupTextElements(MobileReportsViewModel$NodeState viewState) {
        TextView textView = this.binding.m;
        m.checkNotNullExpressionValue(textView, "binding.mobileReportsNodeHeader");
        textView.setText(b.l(viewState.getNode().getHeader(), new Object[0], null, 2));
        String subheader = viewState.getNode().getSubheader();
        LinkifiedTextView linkifiedTextView = this.binding.p;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.mobileReportsNodeSubheader");
        linkifiedTextView.setVisibility(subheader != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = this.binding.p;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.mobileReportsNodeSubheader");
        b.o(linkifiedTextView2, subheader, new Object[0], null, 4);
        String info = viewState.getNode().getInfo();
        MaterialCardView materialCardView = this.binding.n;
        m.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeInfoBox");
        materialCardView.setVisibility(info != null ? 0 : 8);
        TextView textView2 = this.binding.o;
        m.checkNotNullExpressionValue(textView2, "binding.mobileReportsNodeInfoText");
        b.o(textView2, info, new Object[0], null, 4);
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

    public final Function2<ReportNodeChild, MobileReportsViewModel$NodeState, Unit> getHandleSelectChild() {
        return this.handleSelectChild;
    }

    public final Function0<Unit> getHandleSubmit() {
        return this.handleSubmit;
    }

    /* JADX INFO: renamed from: getViewState, reason: from getter */
    public final MobileReportsViewModel$NodeState getPrevViewState() {
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

    public final void setHandleSelectChild(Function2<? super ReportNodeChild, ? super MobileReportsViewModel$NodeState, Unit> function2) {
        this.handleSelectChild = function2;
    }

    public final void setHandleSubmit(Function0<Unit> function0) {
        this.handleSubmit = function0;
    }

    public final void setup(MobileReportsViewModel$NodeState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
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
        m.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingA = ViewReportsMenuNodeBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewReportsMenuNodeBindingA, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingA;
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
        m.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingA = ViewReportsMenuNodeBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewReportsMenuNodeBindingA, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingA;
    }
}
