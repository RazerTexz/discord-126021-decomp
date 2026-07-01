package com.discord.widgets.botuikit;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.LinearLayout;
import b.a.k.b;
import com.discord.api.botuikit.TextComponent;
import com.discord.databinding.BotUikitTextInputBinding;
import com.discord.stores.StoreStream;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ List $components;
    public final /* synthetic */ View $view;
    public final /* synthetic */ ModalComponent this$0;

    public ModalComponent$onViewBound$2(ModalComponent modalComponent, List list, View view) {
        this.this$0 = modalComponent;
        this.$components = list;
        this.$view = view;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (Pair pair : this.$components) {
            TextComponent textComponent = (TextComponent) pair.component1();
            BotUikitTextInputBinding botUikitTextInputBinding = (BotUikitTextInputBinding) pair.component2();
            TextInputEditText textInputEditText = botUikitTextInputBinding.f2089b;
            m.checkNotNullExpressionValue(textInputEditText, "text.editText");
            String strValueOf = String.valueOf(textInputEditText.getText());
            if (strValueOf.length() == 0) {
                if (m.areEqual(textComponent.getRequired(), Boolean.TRUE)) {
                    TextInputLayout textInputLayout = botUikitTextInputBinding.d;
                    m.checkNotNullExpressionValue(textInputLayout, "text.layout");
                    textInputLayout.setError(b.k(this.this$0, 2131889298, new Object[]{Integer.valueOf(textComponent.getMinLength()), Integer.valueOf(textComponent.getMaxLength())}, null, 4));
                    z2 = false;
                }
            } else if (strValueOf.length() < textComponent.getMinLength() || strValueOf.length() > textComponent.getMaxLength()) {
                TextInputLayout textInputLayout2 = botUikitTextInputBinding.d;
                m.checkNotNullExpressionValue(textInputLayout2, "text.layout");
                textInputLayout2.setError(b.k(this.this$0, 2131889298, new Object[]{Integer.valueOf(textComponent.getMinLength()), Integer.valueOf(textComponent.getMaxLength())}, null, 4));
                z2 = false;
            }
            arrayList.add(new Pair(textComponent.getCustomId(), strValueOf));
        }
        if (z2) {
            ModalComponent.access$setSentNonce$p(this.this$0, null);
            LinearLayout linearLayout = ModalComponent.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(linearLayout, "binding.error");
            linearLayout.setVisibility(8);
            MaterialButton materialButton = ModalComponent.access$getBinding$p(this.this$0).f;
            m.checkNotNullExpressionValue(materialButton, "binding.submit");
            materialButton.setEnabled(false);
            StoreStream.Companion.getInteractions().sendModalInteraction(this.this$0.getArgs().getModal(), arrayList, new ModalComponent$onViewBound$2$2(this), new ModalComponent$onViewBound$2$3(this));
        }
    }
}
