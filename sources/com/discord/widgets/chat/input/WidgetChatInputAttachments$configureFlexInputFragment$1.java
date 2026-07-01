package com.discord.widgets.chat.input;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppFragment;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputFragment$1 extends o implements Function0<Unit> {
    public final /* synthetic */ AppFragment $fragment;
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$configureFlexInputFragment$1(WidgetChatInputAttachments widgetChatInputAttachments, AppFragment appFragment) {
        super(0);
        this.this$0 = widgetChatInputAttachments;
        this.$fragment = appFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.configureFlexInputContentPages(false);
        FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0);
        FileManager fileManager = this.$fragment.getFileManager();
        Objects.requireNonNull(flexInputFragmentAccess$getFlexInputFragment$p);
        m.checkNotNullParameter(fileManager, "<set-?>");
        flexInputFragmentAccess$getFlexInputFragment$p.fileManager = fileManager;
        flexInputFragmentAccess$getFlexInputFragment$p.keyboardManager = new WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1(this);
        WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).l().setInputContentHandler(new WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2(this));
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapterAccess$createPreviewAdapter = WidgetChatInputAttachments.access$createPreviewAdapter(this.this$0, this.$fragment.getContext());
        m.checkNotNullParameter(attachmentPreviewAdapterAccess$createPreviewAdapter, "previewAdapter");
        attachmentPreviewAdapterAccess$createPreviewAdapter.selectionAggregator.initFrom((SelectionAggregator<T>) flexInputFragmentAccess$getFlexInputFragment$p.b());
        flexInputFragmentAccess$getFlexInputFragment$p.attachmentPreviewAdapter = attachmentPreviewAdapterAccess$createPreviewAdapter;
        RecyclerView recyclerView = flexInputFragmentAccess$getFlexInputFragment$p.j().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.attachmentPreviewList");
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragmentAccess$getFlexInputFragment$p.attachmentPreviewAdapter;
        if (attachmentPreviewAdapter == null) {
            m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
        }
        recyclerView.setAdapter(attachmentPreviewAdapter);
        WidgetChatInputAttachments widgetChatInputAttachments = this.this$0;
        FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        Fragment fragmentAccess$createAndConfigureExpressionFragment = WidgetChatInputAttachments.access$createAndConfigureExpressionFragment(widgetChatInputAttachments, childFragmentManager, WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).l());
        if (fragmentAccess$createAndConfigureExpressionFragment == null) {
            return;
        }
        flexInputFragmentAccess$getFlexInputFragment$p.getChildFragmentManager().beginTransaction().replace(R$f.expression_tray_container, fragmentAccess$createAndConfigureExpressionFragment, fragmentAccess$createAndConfigureExpressionFragment.getClass().getSimpleName()).commit();
        AppCompatImageButton appCompatImageButton = flexInputFragmentAccess$getFlexInputFragment$p.j().i;
        m.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
        appCompatImageButton.setVisibility(0);
    }
}
