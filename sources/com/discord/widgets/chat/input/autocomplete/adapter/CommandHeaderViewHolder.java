package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.models.commands.Application;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommandHeaderViewHolder extends RecyclerView.ViewHolder implements StickyHeaderHolder {
    private final WidgetChatInputCommandApplicationHeaderItemBinding binding;
    private ApplicationPlaceholder currentItem;
    private final View itemView;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.CommandHeaderViewHolder$bind$1 */
    /* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
    public static final class C77981 extends AbstractC12240o implements Function1<MGImagesBitmap.CloseableBitmaps, Unit> {
        public final /* synthetic */ String $iconUrl;
        public final /* synthetic */ ApplicationPlaceholder $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77981(ApplicationPlaceholder applicationPlaceholder, String str) {
            super(1);
            this.$item = applicationPlaceholder;
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            invoke2(closeableBitmaps);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            Application application;
            C12238m.checkNotNullParameter(closeableBitmaps, "closeableBitmaps");
            ApplicationPlaceholder currentItem = CommandHeaderViewHolder.this.getCurrentItem();
            if (C12103t.equals$default((currentItem == null || (application = currentItem.getApplication()) == null) ? null : application.getIcon(), this.$item.getApplication().getIcon(), false, 2, null)) {
                CommandHeaderViewHolder.this.binding.f16115b.setImageBitmap((Bitmap) closeableBitmaps.get((Object) this.$iconUrl));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.CommandHeaderViewHolder$bind$2 */
    /* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
    public static final class C77992 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ int $tint;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C77992(int i) {
            super(1);
            this.$tint = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "<anonymous parameter 0>");
            ImageView imageView = CommandHeaderViewHolder.this.binding.f16115b;
            C12238m.checkNotNullExpressionValue(imageView, "binding.chatInputApplicationAvatar");
            Context context = imageView.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.chatInputApplicationAvatar.context");
            Drawable drawable$default = DrawableCompat.getDrawable$default(context, C5419R.drawable.ic_slash_command_24dp, this.$tint, false, 4, null);
            if (drawable$default != null) {
                CommandHeaderViewHolder.this.binding.f16115b.setImageDrawable(drawable$default);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandHeaderViewHolder(WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBinding) {
        super(widgetChatInputCommandApplicationHeaderItemBinding.f16114a);
        C12238m.checkNotNullParameter(widgetChatInputCommandApplicationHeaderItemBinding, "binding");
        this.binding = widgetChatInputCommandApplicationHeaderItemBinding;
        ConstraintLayout constraintLayout = widgetChatInputCommandApplicationHeaderItemBinding.f16114a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        this.itemView = constraintLayout;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.adapter.StickyHeaderHolder
    public void bind(ApplicationPlaceholder item) {
        String name;
        C12238m.checkNotNullParameter(item, "item");
        if (C12238m.areEqual(this.currentItem, item)) {
            return;
        }
        this.currentItem = item;
        User bot = item.getApplication().getBot();
        if (bot == null || (name = bot.getUsername()) == null) {
            name = item.getApplication().getName();
        }
        TextView textView = this.binding.f16116c;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatInputApplicationName");
        textView.setText(name);
        ImageView imageView = this.binding.f16115b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.chatInputApplicationAvatar");
        int themedColor = ColorCompat.getThemedColor(imageView, C5419R.attr.colorTextMuted);
        if (item.getApplication().getIconRes() == null) {
            String applicationIcon$default = IconUtils.getApplicationIcon$default(IconUtils.INSTANCE, item.getApplication(), 0, 2, (Object) null);
            HashSet hashSet = new HashSet();
            hashSet.add(new MGImagesBitmap.ImageRequest(applicationIcon$default, true));
            this.binding.f16115b.setImageBitmap(null);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(MGImagesBitmap.getBitmaps(hashSet)), (Class<?>) CommandHeaderViewHolder.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C77992(themedColor)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C77981(item, applicationIcon$default));
            return;
        }
        ImageView imageView2 = this.binding.f16115b;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.chatInputApplicationAvatar");
        Context context = imageView2.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.chatInputApplicationAvatar.context");
        Drawable drawable$default = DrawableCompat.getDrawable$default(context, item.getApplication().getIconRes().intValue(), themedColor, false, 4, null);
        if (drawable$default != null) {
            this.binding.f16115b.setImageDrawable(drawable$default);
        } else {
            this.binding.f16115b.setImageResource(item.getApplication().getIconRes().intValue());
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
