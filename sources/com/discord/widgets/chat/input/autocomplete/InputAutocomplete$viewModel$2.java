package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$viewModel$2 extends o implements Function0<AutocompleteViewModel> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$viewModel$2(InputAutocomplete inputAutocomplete) {
        super(0);
        this.this$0 = inputAutocomplete;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AutocompleteViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AutocompleteViewModel invoke() {
        return new AutocompleteViewModel(InputAutocomplete.access$getChannel$p(this.this$0), InputAutocomplete.access$getFlexInputViewModel$p(this.this$0), null, StoreStream.Companion.getExperiments(), ColorCompat.getThemedColor(InputAutocomplete.access$getEditText$p(this.this$0), 2130970287), ColorCompat.getThemedColor(InputAutocomplete.access$getEditText$p(this.this$0), 2130968898), ColorCompat.getColor(InputAutocomplete.access$getEditText$p(this.this$0), 2131100382), null, Opcodes.IINC, null);
    }
}
