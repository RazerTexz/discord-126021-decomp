package com.discord.widgets.changelog;

import android.content.Context;
import com.discord.R;
import com.discord.utilities.textprocessing.node.UrlNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.widgets.changelog.ChangeLogParser$parse$renderContext$1, reason: use source file name */
/* JADX INFO: compiled from: ChangeLogParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangeLogParser2 implements UrlNode.RenderContext {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Function3 $onClickListener;
    private final Context context;
    private final int linkColorAttrResId = R.attr.colorTextLink;
    private final Function1<String, Unit> onLongPressUrl = new ChangeLogParser3(this);

    public ChangeLogParser2(Function3 function3, Context context) {
        this.$onClickListener = function3;
        this.$context = context;
        this.context = context;
    }

    @Override // com.discord.utilities.textprocessing.node.BasicRenderContext, com.discord.utilities.textprocessing.node.UserMentionNode.RenderContext, com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public int getLinkColorAttrResId() {
        return this.linkColorAttrResId;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public Function3<Context, String, String, Unit> getOnClickUrl() {
        return this.$onClickListener;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode.RenderContext
    public Function1<String, Unit> getOnLongPressUrl() {
        return this.onLongPressUrl;
    }
}
