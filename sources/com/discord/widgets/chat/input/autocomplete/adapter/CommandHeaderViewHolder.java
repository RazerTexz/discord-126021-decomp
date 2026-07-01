package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.images.MGImagesBitmap$ImageRequest;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;
import d0.z.d.m;
import java.util.HashSet;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommandHeaderViewHolder extends RecyclerView$ViewHolder implements StickyHeaderHolder {
    private final WidgetChatInputCommandApplicationHeaderItemBinding binding;
    private ApplicationPlaceholder currentItem;
    private final View itemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandHeaderViewHolder(WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBinding) {
        super(widgetChatInputCommandApplicationHeaderItemBinding.a);
        m.checkNotNullParameter(widgetChatInputCommandApplicationHeaderItemBinding, "binding");
        this.binding = widgetChatInputCommandApplicationHeaderItemBinding;
        ConstraintLayout constraintLayout = widgetChatInputCommandApplicationHeaderItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        this.itemView = constraintLayout;
    }

    public static final /* synthetic */ WidgetChatInputCommandApplicationHeaderItemBinding access$getBinding$p(CommandHeaderViewHolder commandHeaderViewHolder) {
        return commandHeaderViewHolder.binding;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.adapter.StickyHeaderHolder
    public void bind(ApplicationPlaceholder item) {
        String name;
        m.checkNotNullParameter(item, "item");
        if (m.areEqual(this.currentItem, item)) {
            return;
        }
        this.currentItem = item;
        User bot = item.getApplication().getBot();
        if (bot == null || (name = bot.getUsername()) == null) {
            name = item.getApplication().getName();
        }
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.chatInputApplicationName");
        textView.setText(name);
        ImageView imageView = this.binding.f2305b;
        m.checkNotNullExpressionValue(imageView, "binding.chatInputApplicationAvatar");
        int themedColor = ColorCompat.getThemedColor(imageView, 2130969056);
        if (item.getApplication().getIconRes() == null) {
            String applicationIcon$default = IconUtils.getApplicationIcon$default(IconUtils.INSTANCE, item.getApplication(), 0, 2, (Object) null);
            HashSet hashSet = new HashSet();
            hashSet.add(new MGImagesBitmap$ImageRequest(applicationIcon$default, true));
            this.binding.f2305b.setImageBitmap(null);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(MGImagesBitmap.getBitmaps(hashSet)), CommandHeaderViewHolder.class, (Context) null, (Function1) null, new CommandHeaderViewHolder$bind$2(this, themedColor), (Function0) null, (Function0) null, new CommandHeaderViewHolder$bind$1(this, item, applicationIcon$default), 54, (Object) null);
            return;
        }
        ImageView imageView2 = this.binding.f2305b;
        m.checkNotNullExpressionValue(imageView2, "binding.chatInputApplicationAvatar");
        Context context = imageView2.getContext();
        m.checkNotNullExpressionValue(context, "binding.chatInputApplicationAvatar.context");
        Drawable drawable$default = DrawableCompat.getDrawable$default(context, item.getApplication().getIconRes().intValue(), themedColor, false, 4, null);
        if (drawable$default != null) {
            this.binding.f2305b.setImageDrawable(drawable$default);
        } else {
            this.binding.f2305b.setImageResource(item.getApplication().getIconRes().intValue());
        }
    }

    public final ApplicationPlaceholder getCurrentItem() {
        return this.currentItem;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.adapter.StickyHeaderHolder
    public View getItemView() {
        return this.itemView;
    }

    public final void setCurrentItem(ApplicationPlaceholder applicationPlaceholder) {
        this.currentItem = applicationPlaceholder;
    }
}
