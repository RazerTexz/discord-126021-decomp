package com.discord.widgets.chat.input.autocomplete.adapter;

import android.graphics.Bitmap;
import com.discord.models.commands.Application;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import com.discord.widgets.chat.input.autocomplete.ApplicationPlaceholder;
import d0.g0.t;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CommandHeaderViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommandHeaderViewHolder$bind$1 extends o implements Function1<MGImagesBitmap$CloseableBitmaps, Unit> {
    public final /* synthetic */ String $iconUrl;
    public final /* synthetic */ ApplicationPlaceholder $item;
    public final /* synthetic */ CommandHeaderViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandHeaderViewHolder$bind$1(CommandHeaderViewHolder commandHeaderViewHolder, ApplicationPlaceholder applicationPlaceholder, String str) {
        super(1);
        this.this$0 = commandHeaderViewHolder;
        this.$item = applicationPlaceholder;
        this.$iconUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        invoke2(mGImagesBitmap$CloseableBitmaps);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        Application application;
        m.checkNotNullParameter(mGImagesBitmap$CloseableBitmaps, "closeableBitmaps");
        ApplicationPlaceholder currentItem = this.this$0.getCurrentItem();
        if (t.equals$default((currentItem == null || (application = currentItem.getApplication()) == null) ? null : application.getIcon(), this.$item.getApplication().getIcon(), false, 2, null)) {
            CommandHeaderViewHolder.access$getBinding$p(this.this$0).f2305b.setImageBitmap((Bitmap) mGImagesBitmap$CloseableBitmaps.get((Object) this.$iconUrl));
        }
    }
}
