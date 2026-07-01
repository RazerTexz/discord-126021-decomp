package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChatInputCommandApplicationHeaderItemBinding;
import com.discord.models.commands.Application;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommandHeaderViewHolder extends RecyclerView.ViewHolder implements StickyHeaderManager2 {
    private final WidgetChatInputCommandApplicationHeaderItemBinding binding;
    private ApplicationPlaceholder currentItem;
    private final View itemView;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.CommandHeaderViewHolder$bind$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MGImagesBitmap.CloseableBitmaps, Unit> {
        public final /* synthetic */ String $iconUrl;
        public final /* synthetic */ ApplicationPlaceholder $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ApplicationPlaceholder applicationPlaceholder, String str) {
            super(1);
            this.$item = applicationPlaceholder;
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            invoke2(closeableBitmaps);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            Application application;
            Intrinsics3.checkNotNullParameter(closeableBitmaps, "closeableBitmaps");
            ApplicationPlaceholder currentItem = CommandHeaderViewHolder.this.getCurrentItem();
            if (StringsJVM.equals$default((currentItem == null || (application = currentItem.getApplication()) == null) ? null : application.getIcon(), this.$item.getApplication().getIcon(), false, 2, null)) {
                CommandHeaderViewHolder.this.binding.f2305b.setImageBitmap((Bitmap) closeableBitmaps.get((Object) this.$iconUrl));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.CommandHeaderViewHolder$bind$2, reason: invalid class name */
    /* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ int $tint;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i) {
            super(1);
            this.$tint = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "<anonymous parameter 0>");
            ImageView imageView = CommandHeaderViewHolder.this.binding.f2305b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatInputApplicationAvatar");
            Context context = imageView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.chatInputApplicationAvatar.context");
            Drawable drawable$default = DrawableCompat.getDrawable$default(context, R.drawable.ic_slash_command_24dp, this.$tint, false, 4, null);
            if (drawable$default != null) {
                CommandHeaderViewHolder.this.binding.f2305b.setImageDrawable(drawable$default);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandHeaderViewHolder(WidgetChatInputCommandApplicationHeaderItemBinding widgetChatInputCommandApplicationHeaderItemBinding) {
        super(widgetChatInputCommandApplicationHeaderItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChatInputCommandApplicationHeaderItemBinding, "binding");
        this.binding = widgetChatInputCommandApplicationHeaderItemBinding;
        ConstraintLayout constraintLayout = widgetChatInputCommandApplicationHeaderItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        this.itemView = constraintLayout;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.adapter.StickyHeaderManager2
    public void bind(ApplicationPlaceholder item) {
        String name;
        Intrinsics3.checkNotNullParameter(item, "item");
        if (Intrinsics3.areEqual(this.currentItem, item)) {
            return;
        }
        this.currentItem = item;
        User bot = item.getApplication().getBot();
        if (bot == null || (name = bot.getUsername()) == null) {
            name = item.getApplication().getName();
        }
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputApplicationName");
        textView.setText(name);
        ImageView imageView = this.binding.f2305b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatInputApplicationAvatar");
        int themedColor = ColorCompat.getThemedColor(imageView, R.attr.colorTextMuted);
        if (item.getApplication().getIconRes() == null) {
            String applicationIcon$default = IconUtils.getApplicationIcon$default(IconUtils.INSTANCE, item.getApplication(), 0, 2, (Object) null);
            HashSet hashSet = new HashSet();
            hashSet.add(new MGImagesBitmap.ImageRequest(applicationIcon$default, true));
            this.binding.f2305b.setImageBitmap(null);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(MGImagesBitmap.getBitmaps(hashSet)), (Class<?>) CommandHeaderViewHolder.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(themedColor)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(item, applicationIcon$default));
            return;
        }
        ImageView imageView2 = this.binding.f2305b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.chatInputApplicationAvatar");
        Context context = imageView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.chatInputApplicationAvatar.context");
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

    @Override // com.discord.widgets.chat.input.autocomplete.adapter.StickyHeaderManager2
    public View getItemView() {
        return this.itemView;
    }

    public final void setCurrentItem(ApplicationPlaceholder applicationPlaceholder) {
        this.currentItem = applicationPlaceholder;
    }
}
