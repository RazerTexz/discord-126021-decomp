package com.discord.widgets.chat.input;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.commands.Application;

/* JADX INFO: compiled from: WidgetChatInputCategoriesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCategoryViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ Application $application;
    public final /* synthetic */ ApplicationCategoryViewHolder this$0;

    public ApplicationCategoryViewHolder$bind$1(ApplicationCategoryViewHolder applicationCategoryViewHolder, Application application) {
        this.this$0 = applicationCategoryViewHolder;
        this.$application = application;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ApplicationCategoryViewHolder.access$getOnItemSelected$p(this.this$0).invoke(this.$application);
    }
}
