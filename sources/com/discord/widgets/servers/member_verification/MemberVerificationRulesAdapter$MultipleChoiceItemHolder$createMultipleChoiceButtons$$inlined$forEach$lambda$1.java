package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.RadioGroup;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationRulesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter$MultipleChoiceItemHolder$createMultipleChoiceButtons$$inlined$forEach$lambda$1 implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function1 $onItemSelected$inlined;
    public final /* synthetic */ RadioGroup $radioGroup$inlined;
    public final /* synthetic */ int $valueIndex;
    public final /* synthetic */ List $valueList$inlined;
    public final /* synthetic */ MemberVerificationRulesAdapter$MultipleChoiceItemHolder this$0;

    public MemberVerificationRulesAdapter$MultipleChoiceItemHolder$createMultipleChoiceButtons$$inlined$forEach$lambda$1(int i, MemberVerificationRulesAdapter$MultipleChoiceItemHolder memberVerificationRulesAdapter$MultipleChoiceItemHolder, List list, RadioGroup radioGroup, Context context, Function1 function1) {
        this.$valueIndex = i;
        this.this$0 = memberVerificationRulesAdapter$MultipleChoiceItemHolder;
        this.$valueList$inlined = list;
        this.$radioGroup$inlined = radioGroup;
        this.$context$inlined = context;
        this.$onItemSelected$inlined = function1;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            this.$onItemSelected$inlined.invoke(Integer.valueOf(this.$valueIndex));
        }
    }
}
