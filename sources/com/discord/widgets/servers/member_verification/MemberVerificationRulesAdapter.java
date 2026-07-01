package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.WidgetMemberVerificationMultipleChoiceRadioItemBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMemberVerificationApproveTermsItemBinding;
import com.discord.databinding.WidgetMemberVerificationHeaderItemBinding;
import com.discord.databinding.WidgetMemberVerificationMultipleChoiceItemBinding;
import com.discord.databinding.WidgetMemberVerificationParagraphItemBinding;
import com.discord.databinding.WidgetMemberVerificationRuleItemBinding;
import com.discord.databinding.WidgetMemberVerificationTextInputItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemMultipleChoice;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemParagraph;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTerm;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTextInput;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private final AppFragment fragment;
    private Function1<? super Boolean, Unit> onUpdateRulesApproval;
    private Function2<? super Integer, Object, Unit> onUserInputDataEntered;

    /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
    public static final class ApproveTermsItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationApproveTermsItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApproveTermsItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_approve_terms_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            CheckedSetting checkedSetting = (CheckedSetting) view;
            WidgetMemberVerificationApproveTermsItemBinding widgetMemberVerificationApproveTermsItemBinding = new WidgetMemberVerificationApproveTermsItemBinding(checkedSetting, checkedSetting);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationApproveTermsItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationApproveTermsItemBinding;
        }

        public static final /* synthetic */ MemberVerificationRulesAdapter access$getAdapter$p(ApproveTermsItemHolder approveTermsItemHolder) {
            return (MemberVerificationRulesAdapter) approveTermsItemHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final MemberVerificationItemApproveTerms memberVerificationItemApproveTerms = (MemberVerificationItemApproveTerms) data;
            CheckedSetting checkedSetting = this.binding.f2487b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.memberVerificationRulesCheck");
            checkedSetting.setChecked(memberVerificationItemApproveTerms.isApproved());
            this.binding.f2487b.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$ApproveTermsItemHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberVerificationRulesAdapter.ApproveTermsItemHolder.access$getAdapter$p(this.this$0).getOnUpdateRulesApproval().invoke(Boolean.valueOf(!memberVerificationItemApproveTerms.isApproved()));
                }
            });
        }
    }

    /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
    public static final class ItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_header_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetMemberVerificationHeaderItemBinding widgetMemberVerificationHeaderItemBinding = new WidgetMemberVerificationHeaderItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationHeaderItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f2489b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRulesHeader");
            textView.setText(((MemberVerificationItemHeader) data).getTitle());
        }
    }

    /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
    public static final class MultipleChoiceItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationMultipleChoiceItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultipleChoiceItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_multiple_choice_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            RadioGroup radioGroup = (RadioGroup) view;
            WidgetMemberVerificationMultipleChoiceItemBinding widgetMemberVerificationMultipleChoiceItemBinding = new WidgetMemberVerificationMultipleChoiceItemBinding(radioGroup, radioGroup);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationMultipleChoiceItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationMultipleChoiceItemBinding;
        }

        public static final /* synthetic */ MemberVerificationRulesAdapter access$getAdapter$p(MultipleChoiceItemHolder multipleChoiceItemHolder) {
            return (MemberVerificationRulesAdapter) multipleChoiceItemHolder.adapter;
        }

        private final void createMultipleChoiceButtons(final Context context, final RadioGroup radioGroup, final List<String> valueList, final Function1<? super Integer, Unit> onItemSelected) {
            RadioButton radioButton;
            for (String str : valueList) {
                final int iIndexOf = valueList.indexOf(str);
                if (iIndexOf >= radioGroup.getChildCount()) {
                    View viewInflate = LayoutInflater.from(context).inflate(R.layout.widget_member_verification_multiple_choice_radio_item, (ViewGroup) radioGroup, false);
                    Objects.requireNonNull(viewInflate, "rootView");
                    radioButton = (RadioButton) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new WidgetMemberVerificationMultipleChoiceRadioItemBinding(radioButton), "WidgetMemberVerification…        false\n          )");
                    Intrinsics3.checkNotNullExpressionValue(radioButton, "WidgetMemberVerification…   false\n          ).root");
                    radioGroup.addView(radioButton);
                } else {
                    View childAt = this.binding.f2490b.getChildAt(iIndexOf);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                    radioButton = (RadioButton) childAt;
                }
                RadioButton radioButton2 = radioButton;
                radioButton2.setText(str);
                radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$MultipleChoiceItemHolder$createMultipleChoiceButtons$$inlined$forEach$lambda$1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        if (z2) {
                            onItemSelected.invoke(Integer.valueOf(iIndexOf));
                        }
                    }
                });
            }
            int childCount = radioGroup.getChildCount();
            for (int size = valueList.size(); size < childCount; size++) {
                View childAt2 = this.binding.f2490b.getChildAt(size);
                Intrinsics3.checkNotNullExpressionValue(childAt2, "radioButton");
                childAt2.setVisibility(8);
            }
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemMultipleChoice memberVerificationItemMultipleChoice = (MemberVerificationItemMultipleChoice) data;
            Integer response = memberVerificationItemMultipleChoice.getResponse();
            Context contextX = outline.x(this.itemView, "itemView", "itemView.context");
            RadioGroup radioGroup = this.binding.f2490b;
            Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.memberVerificationMultipleChoiceRadioGroup");
            createMultipleChoiceButtons(contextX, radioGroup, memberVerificationItemMultipleChoice.getChoices(), new MemberVerificationRulesAdapter4(this, data));
            if (response != null) {
                View childAt = this.binding.f2490b.getChildAt(response.intValue());
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                ((RadioButton) childAt).setChecked(true);
            }
        }
    }

    /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
    public static final class ParagraphItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationParagraphItemBinding binding;
        private int fieldIndex;

        /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$ParagraphItemHolder$1, reason: invalid class name */
        /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
            public final /* synthetic */ MemberVerificationRulesAdapter $adapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
                super(1);
                this.$adapter = memberVerificationRulesAdapter;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Editable editable) {
                Intrinsics3.checkNotNullParameter(editable, "editable");
                this.$adapter.getOnUserInputDataEntered().invoke(Integer.valueOf(ParagraphItemHolder.this.fieldIndex), editable.toString());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParagraphItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_paragraph_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.member_verification_paragraph_field);
            if (textInputEditText == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.member_verification_paragraph_field)));
            }
            WidgetMemberVerificationParagraphItemBinding widgetMemberVerificationParagraphItemBinding = new WidgetMemberVerificationParagraphItemBinding((TextInputLayout) view, textInputEditText);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationParagraphItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationParagraphItemBinding;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.memberVerificationParagraphField");
            TextWatcher4.addBindedTextWatcher(textInputEditText, memberVerificationRulesAdapter.getFragment(), new AnonymousClass1(memberVerificationRulesAdapter));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemParagraph memberVerificationItemParagraph = (MemberVerificationItemParagraph) data;
            this.fieldIndex = memberVerificationItemParagraph.getFieldIndex();
            this.binding.f2491b.setText(memberVerificationItemParagraph.getResponse());
            TextInputEditText textInputEditText = this.binding.f2491b;
            String response = memberVerificationItemParagraph.getResponse();
            textInputEditText.setSelection(response != null ? response.length() : 0);
        }
    }

    /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
    public static final class TermHeaderItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TermHeaderItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_header_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetMemberVerificationHeaderItemBinding widgetMemberVerificationHeaderItemBinding = new WidgetMemberVerificationHeaderItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationHeaderItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f2489b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRulesHeader");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            textView.setText(view.getResources().getString(R.string.member_verification_form_rules_label));
        }
    }

    /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
    public static final class TermItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationRuleItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TermItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_rule_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.member_verification_rule_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.member_verification_rule_container);
            if (linearLayout != null) {
                i = R.id.member_verification_rule_description;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.member_verification_rule_description);
                if (simpleDraweeSpanTextView != null) {
                    i = R.id.member_verification_rule_divider;
                    View viewFindViewById = view.findViewById(R.id.member_verification_rule_divider);
                    if (viewFindViewById != null) {
                        i = R.id.member_verification_rule_index;
                        TextView textView = (TextView) view.findViewById(R.id.member_verification_rule_index);
                        if (textView != null) {
                            RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) view;
                            WidgetMemberVerificationRuleItemBinding widgetMemberVerificationRuleItemBinding = new WidgetMemberVerificationRuleItemBinding(roundedRelativeLayout, linearLayout, simpleDraweeSpanTextView, viewFindViewById, textView, roundedRelativeLayout);
                            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationRuleItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
                            this.binding = widgetMemberVerificationRuleItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemTerm memberVerificationItemTerm = (MemberVerificationItemTerm) data;
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationRuleIndex");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            Resources resources = view.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
            int index = memberVerificationItemTerm.getIndex();
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            textView.setText(FormatUtils.c(resources, R.string.member_verification_rule_index, new Object[]{StringUtils2.format(index, context)}, (4 & 4) != 0 ? FormatUtils.d.j : null));
            this.binding.f2493b.setDraweeSpanStringBuilder(AstRenderer.render(memberVerificationItemTerm.getAst(), new MessageRenderContext(outline.x(this.itemView, "itemView", "itemView.context"), 0L, memberVerificationItemTerm.getAllowAnimatedEmojis(), null, memberVerificationItemTerm.getChannelNames(), memberVerificationItemTerm.getRoles(), 0, null, null, 0, 0, null, null, null, 16328, null)));
            View view3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(view3, "binding.memberVerificationRuleDivider");
            view3.setVisibility(memberVerificationItemTerm.isLastItem() ^ true ? 0 : 8);
            float fDpToPixels = DimenUtils.dpToPixels(4);
            if (memberVerificationItemTerm.isFirstItem()) {
                this.binding.e.updateTopLeftRadius(fDpToPixels);
                this.binding.e.updateTopRightRadius(fDpToPixels);
            }
            if (memberVerificationItemTerm.isLastItem()) {
                this.binding.e.updateBottomLeftRadius(fDpToPixels);
                this.binding.e.updateBottomRightRadius(fDpToPixels);
            }
        }
    }

    /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
    public static final class TextInputItemHolder extends MGRecyclerViewHolder<MemberVerificationRulesAdapter, MGRecyclerDataPayload> {
        private final WidgetMemberVerificationTextInputItemBinding binding;
        private int fieldIndex;

        /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$TextInputItemHolder$1, reason: invalid class name */
        /* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
            public final /* synthetic */ MemberVerificationRulesAdapter $adapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
                super(1);
                this.$adapter = memberVerificationRulesAdapter;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
                invoke2(editable);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Editable editable) {
                Intrinsics3.checkNotNullParameter(editable, "editable");
                this.$adapter.getOnUserInputDataEntered().invoke(Integer.valueOf(TextInputItemHolder.this.fieldIndex), editable.toString());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextInputItemHolder(MemberVerificationRulesAdapter memberVerificationRulesAdapter) {
            super(R.layout.widget_member_verification_text_input_item, memberVerificationRulesAdapter);
            Intrinsics3.checkNotNullParameter(memberVerificationRulesAdapter, "adapter");
            View view = this.itemView;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.member_verification_text_input_field);
            if (textInputEditText == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.member_verification_text_input_field)));
            }
            WidgetMemberVerificationTextInputItemBinding widgetMemberVerificationTextInputItemBinding = new WidgetMemberVerificationTextInputItemBinding((TextInputLayout) view, textInputEditText);
            Intrinsics3.checkNotNullExpressionValue(widgetMemberVerificationTextInputItemBinding, "WidgetMemberVerification…temBinding.bind(itemView)");
            this.binding = widgetMemberVerificationTextInputItemBinding;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.memberVerificationTextInputField");
            TextWatcher4.addBindedTextWatcher(textInputEditText, memberVerificationRulesAdapter.getFragment(), new AnonymousClass1(memberVerificationRulesAdapter));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            MemberVerificationItemTextInput memberVerificationItemTextInput = (MemberVerificationItemTextInput) data;
            this.fieldIndex = memberVerificationItemTextInput.getFieldIndex();
            this.binding.f2495b.setText(memberVerificationItemTextInput.getResponse());
            TextInputEditText textInputEditText = this.binding.f2495b;
            String response = memberVerificationItemTextInput.getResponse();
            textInputEditText.setSelection(response != null ? response.length() : 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationRulesAdapter(RecyclerView recyclerView, AppFragment appFragment) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        this.fragment = appFragment;
        this.onUpdateRulesApproval = MemberVerificationRulesAdapter5.INSTANCE;
        this.onUserInputDataEntered = MemberVerificationRulesAdapter6.INSTANCE;
    }

    public final AppFragment getFragment() {
        return this.fragment;
    }

    public final Function1<Boolean, Unit> getOnUpdateRulesApproval() {
        return this.onUpdateRulesApproval;
    }

    public final Function2<Integer, Object, Unit> getOnUserInputDataEntered() {
        return this.onUserInputDataEntered;
    }

    public final void setOnUpdateRulesApproval(Function1<? super Boolean, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onUpdateRulesApproval = function1;
    }

    public final void setOnUserInputDataEntered(Function2<? super Integer, Object, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onUserInputDataEntered = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new ItemHolder(this);
            case 1:
                return new TermHeaderItemHolder(this);
            case 2:
                return new ApproveTermsItemHolder(this);
            case 3:
                return new TermItemHolder(this);
            case 4:
                return new TextInputItemHolder(this);
            case 5:
                return new ParagraphItemHolder(this);
            case 6:
                return new MultipleChoiceItemHolder(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
