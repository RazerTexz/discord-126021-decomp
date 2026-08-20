package com.discord.widgets.chat.input;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.CommandCategoryItemBinding;
import com.discord.models.commands.Application;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatInputCategoriesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCategoryViewHolder extends RecyclerView.ViewHolder {
    private final CommandCategoryItemBinding binding;
    private final Function1<Application, Unit> onItemSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ApplicationCategoryViewHolder(CommandCategoryItemBinding commandCategoryItemBinding, Function1<? super Application, Unit> function1) {
        super(commandCategoryItemBinding.f15018a);
        C12238m.checkNotNullParameter(commandCategoryItemBinding, "binding");
        C12238m.checkNotNullParameter(function1, "onItemSelected");
        this.binding = commandCategoryItemBinding;
        this.onItemSelected = function1;
    }

    public final void bind(final Application application, boolean isSelected) {
        int themedColor;
        C12238m.checkNotNullParameter(application, "application");
        this.binding.f15019b.setImageURI((String) null);
        SimpleDraweeView simpleDraweeView = this.binding.f15019b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.commandCategoryItemIcon");
        IconUtils.setApplicationIcon(simpleDraweeView, application);
        SimpleDraweeView simpleDraweeView2 = this.binding.f15019b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.commandCategoryItemIcon");
        simpleDraweeView2.setSelected(isSelected);
        View view = this.binding.f15020c.f1066b;
        C12238m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
        view.setVisibility(isSelected ? 0 : 8);
        if (isSelected) {
            SimpleDraweeView simpleDraweeView3 = this.binding.f15019b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.commandCategoryItemIcon");
            themedColor = ColorCompat.getThemedColor(simpleDraweeView3, C5419R.attr.colorInteractiveActive);
        } else {
            SimpleDraweeView simpleDraweeView4 = this.binding.f15019b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.commandCategoryItemIcon");
            themedColor = ColorCompat.getThemedColor(simpleDraweeView4, C5419R.attr.colorInteractiveNormal);
        }
        SimpleDraweeView simpleDraweeView5 = this.binding.f15019b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView5, "binding.commandCategoryItemIcon");
        ColorCompatKt.tintWithColor(simpleDraweeView5, themedColor);
        SimpleDraweeView simpleDraweeView6 = this.binding.f15019b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView6, "binding.commandCategoryItemIcon");
        simpleDraweeView6.setAlpha(isSelected ? 1.0f : 0.5f);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.ApplicationCategoryViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ApplicationCategoryViewHolder.this.onItemSelected.invoke(application);
            }
        });
        View view2 = this.itemView;
        C12238m.checkNotNullExpressionValue(view2, "itemView");
        view2.setContentDescription(C1107b.m216h(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.string.command_accessibility_desc_app_item, new Object[]{application.getName()}, null, 4));
    }
}
