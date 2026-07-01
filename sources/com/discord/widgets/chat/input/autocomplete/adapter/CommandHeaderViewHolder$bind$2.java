package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommandHeaderViewHolder$bind$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ int $tint;
    public final /* synthetic */ CommandHeaderViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandHeaderViewHolder$bind$2(CommandHeaderViewHolder commandHeaderViewHolder, int i) {
        super(1);
        this.this$0 = commandHeaderViewHolder;
        this.$tint = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "<anonymous parameter 0>");
        ImageView imageView = CommandHeaderViewHolder.access$getBinding$p(this.this$0).f2305b;
        m.checkNotNullExpressionValue(imageView, "binding.chatInputApplicationAvatar");
        Context context = imageView.getContext();
        m.checkNotNullExpressionValue(context, "binding.chatInputApplicationAvatar.context");
        Drawable drawable$default = DrawableCompat.getDrawable$default(context, 2131232129, this.$tint, false, 4, null);
        if (drawable$default != null) {
            CommandHeaderViewHolder.access$getBinding$p(this.this$0).f2305b.setImageDrawable(drawable$default);
        }
    }
}
