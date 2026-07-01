package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.AppScreen2;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.StoreStream;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.widgets.hubs.WidgetHubAddServer;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryCategory$adapter$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryCategory3 implements DirectoryChannelItemClickInterface {
    public final /* synthetic */ WidgetDirectoryCategory this$0;

    public WidgetDirectoryCategory3(WidgetDirectoryCategory widgetDirectoryCategory) {
        this.this$0 = widgetDirectoryCategory;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onAddServerClicked() {
        if (this.this$0.getContext() != null) {
            AppScreen2.g.f(this.this$0.requireContext(), this.this$0.activityResult, WidgetHubAddServer.class, null);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onEntryClicked(long guildId, long channelId) {
        Context context = this.this$0.getContext();
        if (context != null) {
            WidgetDirectoriesViewModel viewModel = this.this$0.getViewModel();
            Intrinsics3.checkNotNullExpressionValue(context, "it");
            viewModel.joinGuild(context, guildId, channelId);
        }
    }

    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onGoToGuildClicked(long guildId) {
        StoreStream.INSTANCE.getGuildSelected().set(guildId);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.discord.widgets.directories.DirectoryChannelItemClickInterface
    public void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner) {
        Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
        DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
        WidgetDirectoryCategory widgetDirectoryCategory = this.this$0;
        directoryUtils.showServerOptions(widgetDirectoryCategory, directoryEntry, widgetDirectoryCategory.getViewModel().getHubName(), isServerOwner, new WidgetDirectoryCategory4(this, directoryEntry, channelId));
    }
}
