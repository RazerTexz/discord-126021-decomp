package com.discord.widgets.chat.input;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.CommandCategoryItemBinding;
import com.discord.models.commands.Application;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.ApplicationCategoryViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInputCategoriesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputCategoriesAdapter extends RecyclerView.ViewHolder {
    private final CommandCategoryItemBinding binding;
    private final Function1<Application, Unit> onItemSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatInputCategoriesAdapter(CommandCategoryItemBinding commandCategoryItemBinding, Function1<? super Application, Unit> function1) {
        super(commandCategoryItemBinding.a);
        Intrinsics3.checkNotNullParameter(commandCategoryItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onItemSelected");
        this.binding = commandCategoryItemBinding;
        this.onItemSelected = function1;
    }

    public final void bind(final Application application, boolean isSelected) {
        int themedColor;
        Intrinsics3.checkNotNullParameter(application, "application");
        this.binding.f2090b.setImageURI((String) null);
        SimpleDraweeView simpleDraweeView = this.binding.f2090b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.commandCategoryItemIcon");
        IconUtils.setApplicationIcon(simpleDraweeView, application);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2090b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.commandCategoryItemIcon");
        simpleDraweeView2.setSelected(isSelected);
        View view = this.binding.c.f163b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
        view.setVisibility(isSelected ? 0 : 8);
        if (isSelected) {
            SimpleDraweeView simpleDraweeView3 = this.binding.f2090b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.commandCategoryItemIcon");
            themedColor = ColorCompat.getThemedColor(simpleDraweeView3, R.attr.colorInteractiveActive);
        } else {
            SimpleDraweeView simpleDraweeView4 = this.binding.f2090b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.commandCategoryItemIcon");
            themedColor = ColorCompat.getThemedColor(simpleDraweeView4, R.attr.colorInteractiveNormal);
        }
        SimpleDraweeView simpleDraweeView5 = this.binding.f2090b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.commandCategoryItemIcon");
        ColorCompat2.tintWithColor(simpleDraweeView5, themedColor);
        SimpleDraweeView simpleDraweeView6 = this.binding.f2090b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.commandCategoryItemIcon");
        simpleDraweeView6.setAlpha(isSelected ? 1.0f : 0.5f);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.ApplicationCategoryViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetChatInputCategoriesAdapter.this.onItemSelected.invoke(application);
            }
        });
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        view2.setContentDescription(FormatUtils.b(outline.x(this.itemView, "itemView", "itemView.context"), R.string.command_accessibility_desc_app_item, new Object[]{application.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null));
    }
}
