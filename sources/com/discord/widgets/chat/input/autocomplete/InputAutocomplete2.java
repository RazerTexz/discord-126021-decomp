package com.discord.widgets.chat.input.autocomplete;

import com.discord.R;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete2 extends Lambda implements Function0<AutocompleteViewModel> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete2(InputAutocomplete inputAutocomplete) {
        super(0);
        this.this$0 = inputAutocomplete;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AutocompleteViewModel invoke() {
        return new AutocompleteViewModel(this.this$0.channel, this.this$0.flexInputViewModel, null, StoreStream.INSTANCE.getExperiments(), ColorCompat.getThemedColor(this.this$0.editText, R.attr.theme_chat_mention_foreground), ColorCompat.getThemedColor(this.this$0.editText, R.attr.colorBackgroundFloating), ColorCompat.getColor(this.this$0.editText, R.color.status_red_500), null, Opcodes.IINC, null);
    }
}
