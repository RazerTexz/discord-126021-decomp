package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatInputEmojiAutocompleteUpsellItemBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.views.PileView;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.C1107b;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmojiAutocompleteUpsellViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiAutocompleteUpsellViewHolder extends RecyclerView.ViewHolder {
    private final WidgetChatInputEmojiAutocompleteUpsellItemBinding binding;
    private final Function1<Autocompletable, Unit> onItemSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiAutocompleteUpsellViewHolder(WidgetChatInputEmojiAutocompleteUpsellItemBinding widgetChatInputEmojiAutocompleteUpsellItemBinding, Function1<? super Autocompletable, Unit> function1) {
        super(widgetChatInputEmojiAutocompleteUpsellItemBinding.f16117a);
        C12238m.checkNotNullParameter(widgetChatInputEmojiAutocompleteUpsellItemBinding, "binding");
        C12238m.checkNotNullParameter(function1, "onItemSelected");
        this.binding = widgetChatInputEmojiAutocompleteUpsellItemBinding;
        this.onItemSelected = function1;
    }

    public final void bind(final EmojiUpsellPlaceholder emojiUpsellPlaceholder) {
        C12238m.checkNotNullParameter(emojiUpsellPlaceholder, "emojiUpsellPlaceholder");
        int lockedTotal = emojiUpsellPlaceholder.getLockedTotal();
        LinearLayout linearLayout = this.binding.f16117a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
        Resources resources = linearLayout.getResources();
        String string = resources.getString(C5419R.string.autocomplete_emoji_upsell);
        C12238m.checkNotNullExpressionValue(string, "resources.getString(R.st…utocomplete_emoji_upsell)");
        String quantityString = resources.getQuantityString(C5419R.plurals.autocomplete_emoji_upsell_count, lockedTotal);
        C12238m.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…moji_upsell_count, count)");
        TextView textView = this.binding.f16119c;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputEmojiUpsellText");
        C1107b.m223o(textView, string, new Object[]{C1107b.m215g(quantityString, new Object[]{Integer.valueOf(lockedTotal)}, (2 & 2) != 0 ? C1107b.e.f1494j : null)}, null, 4);
        List<Emoji> lockedFirstThree = emojiUpsellPlaceholder.getLockedFirstThree();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(lockedFirstThree, 10));
        Iterator<T> it = lockedFirstThree.iterator();
        while (it.hasNext()) {
            arrayList.add(new PileView.C7089c(new EmojiAutocompleteUpsellViewHolder$bind$$inlined$map$lambda$1((Emoji) it.next(), this, emojiUpsellPlaceholder), null));
        }
        this.binding.f16118b.setItems(arrayList);
        this.binding.f16117a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.autocomplete.adapter.EmojiAutocompleteUpsellViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiAutocompleteUpsellViewHolder.this.onItemSelected.invoke(emojiUpsellPlaceholder);
            }
        });
    }
}
