package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.d.o;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEmojisEditBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$PatchGuildEmoji;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojisEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEmojisEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", 0)};
    public static final WidgetServerSettingsEmojisEdit$Companion Companion = new WidgetServerSettingsEmojisEdit$Companion(null);
    private static final Regex EMOJI_RE = new Regex("[^A-Za-z0-9_]");
    private static final String EXTRA_EMOJI_ALIAS = "EXTRA_EMOJI_ALIAS";
    private static final String EXTRA_EMOJI_ID = "EXTRA_EMOJI_ID";
    private static final String EXTRA_GUILD_ID = "EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long emojiId;
    private String emojiName;
    private long guildId;
    private final StatefulViews state;

    public WidgetServerSettingsEmojisEdit() {
        super(R$layout.widget_server_settings_emojis_edit);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEmojisEdit$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.server_settings_emojis_edit_alias);
        this.guildId = -1L;
        this.emojiId = -1L;
        this.emojiName = "";
    }

    public static final /* synthetic */ void access$deleteEmoji(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        widgetServerSettingsEmojisEdit.deleteEmoji();
    }

    public static final /* synthetic */ long access$getEmojiId$p(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        return widgetServerSettingsEmojisEdit.emojiId;
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        return widgetServerSettingsEmojisEdit.guildId;
    }

    public static final /* synthetic */ void access$handleSaveAlias(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        widgetServerSettingsEmojisEdit.handleSaveAlias();
    }

    public static final /* synthetic */ void access$onSaveSuccess(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit, String str) {
        widgetServerSettingsEmojisEdit.onSaveSuccess(str);
    }

    public static final /* synthetic */ void access$setEmojiId$p(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit, long j) {
        widgetServerSettingsEmojisEdit.emojiId = j;
    }

    public static final /* synthetic */ void access$setGuildId$p(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit, long j) {
        widgetServerSettingsEmojisEdit.guildId = j;
    }

    private final void configureMenu() {
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_server_settings_emojis_edit, new WidgetServerSettingsEmojisEdit$configureMenu$1(this), null, 4, null);
    }

    private final void configureToolbar(String emojiName) {
        setActionBarTitle(2131888749);
        setActionBarSubtitle(emojiName);
    }

    public static final void create(Context context, long j, long j2, String str) {
        Companion.create(context, j, j2, str);
    }

    private final void deleteEmoji() {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        StatefulViews.clear$default(this.state, false, 1, null);
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteGuildEmoji(this.guildId, this.emojiId), false, 1, null), this, null, 2, null).k(o.i(new WidgetServerSettingsEmojisEdit$deleteEmoji$1(this), this));
    }

    private final WidgetServerSettingsEmojisEditBinding getBinding() {
        return (WidgetServerSettingsEmojisEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleSaveAlias() {
        TextInputLayout textInputLayout = getBinding().f2563b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        String strSanitizeEmojiName = sanitizeEmojiName(ViewExtensions.getTextOrEmpty(textInputLayout));
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().patchGuildEmoji(this.guildId, this.emojiId, new RestAPIParams$PatchGuildEmoji(strSanitizeEmojiName)), false, 1, null), this, null, 2, null).k(o.i(new WidgetServerSettingsEmojisEdit$handleSaveAlias$1(this, strSanitizeEmojiName), this));
    }

    private final void onSaveSuccess(String sanitizedName) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        configureToolbar(sanitizedName);
        StoreStream.Companion.getGuildEmojis().fetchGuildEmoji(this.guildId);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().f2563b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        statefulViews.put(textInputLayout.getId(), sanitizedName);
        TextInputLayout textInputLayout2 = getBinding().f2563b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsEmojisEditAlias");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout3 = getBinding().f2563b;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.serverSettingsEmojisEditAlias");
        ViewExtensions.setText(textInputLayout2, (CharSequence) statefulViews2.get(textInputLayout3.getId(), sanitizedName));
        b.a.d.m.j(this, getString(2131895233), 0, 4);
    }

    private final String sanitizeEmojiName(String name) {
        String strReplace = EMOJI_RE.replace(name, "");
        while (strReplace.length() < 2) {
            strReplace = strReplace + '_';
        }
        return strReplace;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.guildId = getMostRecentIntent().getLongExtra(EXTRA_GUILD_ID, -1L);
        this.emojiId = getMostRecentIntent().getLongExtra(EXTRA_EMOJI_ID, -1L);
        String stringExtra = getMostRecentIntent().getStringExtra(EXTRA_EMOJI_ALIAS);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.emojiName = stringExtra;
        TextInputLayout textInputLayout = getBinding().f2563b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f2563b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsEmojisEditAlias");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), this.emojiName));
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().c;
        TextInputLayout textInputLayout3 = getBinding().f2563b;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.serverSettingsEmojisEditAlias");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout3);
        this.state.configureSaveActionView(getBinding().c);
        getBinding().c.setOnClickListener(new WidgetServerSettingsEmojisEdit$onViewBound$1(this));
        configureToolbar(this.emojiName);
        configureMenu();
        if (getIsRecreated()) {
            return;
        }
        TextInputLayout textInputLayout4 = getBinding().f2563b;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.serverSettingsEmojisEditAlias");
        showKeyboard(textInputLayout4);
    }
}
