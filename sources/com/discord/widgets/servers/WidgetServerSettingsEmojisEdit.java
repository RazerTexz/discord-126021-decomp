package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEmojisEditBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import rx.functions.Action1;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojisEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEmojisEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmojisEditBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId, long emojiId, String alias) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(alias, "alias");
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsEmojisEdit.EXTRA_GUILD_ID, guildId).putExtra(WidgetServerSettingsEmojisEdit.EXTRA_EMOJI_ID, emojiId).putExtra(WidgetServerSettingsEmojisEdit.EXTRA_EMOJI_ALIAS, alias);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…EXTRA_EMOJI_ALIAS, alias)");
            AppScreen2.d(context, WidgetServerSettingsEmojisEdit.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetServerSettingsEmojisEdit() {
        super(R.layout.widget_server_settings_emojis_edit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEmojisEdit2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.server_settings_emojis_edit_alias);
        this.guildId = -1L;
        this.emojiId = -1L;
        this.emojiName = "";
    }

    private final void configureMenu() {
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_server_settings_emojis_edit, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit.configureMenu.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_server_settings_emoji_delete) {
                    return;
                }
                WidgetServerSettingsEmojisEdit.this.deleteEmoji();
            }
        }, null, 4, null);
    }

    private final void configureToolbar(String emojiName) {
        setActionBarTitle(R.string.emoji);
        setActionBarSubtitle(emojiName);
    }

    public static final void create(Context context, long j, long j2, String str) {
        INSTANCE.create(context, j, j2, str);
    }

    private final void deleteEmoji() {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        StatefulViews.clear$default(this.state, false, 1, null);
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildEmoji(this.guildId, this.emojiId), false, 1, null), this, null, 2, null).k(o.i(new Action1<Void>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit.deleteEmoji.1
            @Override // rx.functions.Action1
            public final void call(Void r5) throws Exception {
                StoreStream.INSTANCE.getGuildEmojis().deleteEmoji(WidgetServerSettingsEmojisEdit.this.guildId, WidgetServerSettingsEmojisEdit.this.emojiId);
                AppActivity appActivity = WidgetServerSettingsEmojisEdit.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.onBackPressed();
                }
            }
        }, this));
    }

    private final WidgetServerSettingsEmojisEditBinding getBinding() {
        return (WidgetServerSettingsEmojisEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleSaveAlias() {
        TextInputLayout textInputLayout = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        final String strSanitizeEmojiName = sanitizeEmojiName(ViewExtensions.getTextOrEmpty(textInputLayout));
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().patchGuildEmoji(this.guildId, this.emojiId, new RestAPIParams.PatchGuildEmoji(strSanitizeEmojiName)), false, 1, null), this, null, 2, null).k(o.i(new Action1<ModelEmojiGuild>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit.handleSaveAlias.1
            @Override // rx.functions.Action1
            public final void call(ModelEmojiGuild modelEmojiGuild) {
                WidgetServerSettingsEmojisEdit.this.onSaveSuccess(strSanitizeEmojiName);
            }
        }, this));
    }

    private final void onSaveSuccess(String sanitizedName) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        configureToolbar(sanitizedName);
        StoreStream.INSTANCE.getGuildEmojis().fetchGuildEmoji(this.guildId);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        statefulViews.put(textInputLayout.getId(), sanitizedName);
        TextInputLayout textInputLayout2 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsEmojisEditAlias");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout3 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.serverSettingsEmojisEditAlias");
        ViewExtensions.setText(textInputLayout2, (CharSequence) statefulViews2.get(textInputLayout3.getId(), sanitizedName));
        AppToast.j(this, getString(R.string.save_media_success_mobile), 0, 4);
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
        Intrinsics3.checkNotNullParameter(view, "view");
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
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsEmojisEditAlias");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsEmojisEditAlias");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), this.emojiName));
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().c;
        TextInputLayout textInputLayout3 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.serverSettingsEmojisEditAlias");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout3);
        this.state.configureSaveActionView(getBinding().c);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEmojisEdit.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsEmojisEdit.this.handleSaveAlias();
            }
        });
        configureToolbar(this.emojiName);
        configureMenu();
        if (getIsRecreated()) {
            return;
        }
        TextInputLayout textInputLayout4 = getBinding().f2563b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.serverSettingsEmojisEditAlias");
        showKeyboard(textInputLayout4);
    }
}
