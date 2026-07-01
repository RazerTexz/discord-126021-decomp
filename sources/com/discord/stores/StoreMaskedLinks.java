package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.user.User;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.text.Regex;

/* JADX INFO: compiled from: StoreMaskedLinks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMaskedLinks extends StoreV2 {
    public static final StoreMaskedLinks$Companion Companion;
    private static final Regex DISCORD_DOMAINS_REGEX;
    private static final String HOST_SPOTIFY = "https://spotify.com";
    private static final String HOST_SPOTIFY_OPEN = "https://open.spotify.com";
    private static final List<String> TRUSTED_DOMAINS;
    private static final String USER_TRUSTED_DOMAINS_CACHE_KEY = "USER_TRUSTED_DOMAINS_CACHE_KEY";
    private final Dispatcher dispatcher;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreUserRelationships storeUserRelationships;
    private Set<String> userTrustedDomains;
    private Set<String> userTrustedDomainsSnapshot;

    static {
        StoreMaskedLinks$Companion storeMaskedLinks$Companion = new StoreMaskedLinks$Companion(null);
        Companion = storeMaskedLinks$Companion;
        TRUSTED_DOMAINS = n.listOfNotNull((Object[]) new String[]{StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, BuildConfig.HOST), StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, BuildConfig.HOST_ALTERNATE), StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, BuildConfig.HOST_CDN), StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, BuildConfig.HOST_GIFT), StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, BuildConfig.HOST_INVITE), StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, BuildConfig.HOST_GUILD_TEMPLATE), StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, HOST_SPOTIFY), StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, HOST_SPOTIFY_OPEN)});
        DISCORD_DOMAINS_REGEX = new Regex("(?:^|\\.)(?:discordapp|discord)\\.com$");
    }

    public StoreMaskedLinks(Dispatcher dispatcher, StoreChannelsSelected storeChannelsSelected, StoreUserRelationships storeUserRelationships) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        this.dispatcher = dispatcher;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeUserRelationships = storeUserRelationships;
        this.userTrustedDomainsSnapshot = n0.emptySet();
        this.userTrustedDomains = new LinkedHashSet();
    }

    public static final /* synthetic */ Regex access$getDISCORD_DOMAINS_REGEX$cp() {
        return DISCORD_DOMAINS_REGEX;
    }

    public static final /* synthetic */ List access$getTRUSTED_DOMAINS$cp() {
        return TRUSTED_DOMAINS;
    }

    public static final /* synthetic */ Set access$getUserTrustedDomains$p(StoreMaskedLinks storeMaskedLinks) {
        return storeMaskedLinks.userTrustedDomains;
    }

    public static final /* synthetic */ void access$setUserTrustedDomains$p(StoreMaskedLinks storeMaskedLinks, Set set) {
        storeMaskedLinks.userTrustedDomains = set;
    }

    public final Set<String> getUserTrustedDomains() {
        return this.userTrustedDomainsSnapshot;
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        Set<String> stringSet = getPrefs().getStringSet(USER_TRUSTED_DOMAINS_CACHE_KEY, n0.emptySet());
        if (stringSet == null) {
            stringSet = new LinkedHashSet<>();
        }
        this.userTrustedDomains = new HashSet(stringSet);
        markChanged();
    }

    public final boolean isTrustedDomain(String url, String mask) {
        m.checkNotNullParameter(url, "url");
        if (isTrustedDomain(url)) {
            return true;
        }
        boolean z2 = mask == null || m.areEqual(mask, url);
        Channel selectedChannel = this.storeChannelsSelected.getSelectedChannel();
        User userA = selectedChannel != null ? ChannelUtils.a(selectedChannel) : null;
        if (ModelUserRelationship.isType(this.storeUserRelationships.getRelationships().get(userA != null ? Long.valueOf(userA.getId()) : null), 1)) {
            return z2;
        }
        return false;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.userTrustedDomainsSnapshot = new HashSet(this.userTrustedDomains);
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefs().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putStringSet(USER_TRUSTED_DOMAINS_CACHE_KEY, this.userTrustedDomainsSnapshot);
        sharedPreferences$EditorEdit.apply();
    }

    public final void trustDomain(String url) {
        m.checkNotNullParameter(url, "url");
        this.dispatcher.schedule(new StoreMaskedLinks$trustDomain$1(this, url));
    }

    private final boolean isTrustedDomain(String url) {
        StoreMaskedLinks$Companion storeMaskedLinks$Companion = Companion;
        String strAccess$getDomainName = StoreMaskedLinks$Companion.access$getDomainName(storeMaskedLinks$Companion, url);
        return u.contains(this.userTrustedDomainsSnapshot, strAccess$getDomainName) || (strAccess$getDomainName != null && storeMaskedLinks$Companion.isImplicitlyTrustedDomain$app_productionGoogleRelease(strAccess$getDomainName));
    }
}
