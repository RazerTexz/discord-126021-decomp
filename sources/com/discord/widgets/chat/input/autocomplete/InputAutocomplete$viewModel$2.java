package com.discord.widgets.chat.input.autocomplete;

import com.discord.C5419R;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$viewModel$2 extends AbstractC12240o implements Function0<AutocompleteViewModel> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$viewModel$2(InputAutocomplete inputAutocomplete) {
        super(0);
        this.this$0 = inputAutocomplete;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AutocompleteViewModel invoke() {
        return new AutocompleteViewModel(this.this$0.channel, this.this$0.flexInputViewModel, null, StoreStream.INSTANCE.getExperiments(), ColorCompat.getThemedColor(this.this$0.editText, C5419R.attr.theme_chat_mention_foreground), ColorCompat.getThemedColor(this.this$0.editText, C5419R.attr.colorBackgroundFloating), ColorCompat.getColor(this.this$0.editText, C5419R.color.status_red_500), null, Opcodes.IINC, null);
    }
}
