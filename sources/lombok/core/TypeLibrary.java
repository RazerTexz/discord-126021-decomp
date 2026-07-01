package lombok.core;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: app.apk:lombok/core/TypeLibrary.SCL.lombok */
public class TypeLibrary {
    private final Map<String, Object> unqualifiedToQualifiedMap;
    private final String unqualified;
    private final String qualified;
    private boolean locked;

    public TypeLibrary() {
        this.unqualifiedToQualifiedMap = new HashMap();
        this.unqualified = null;
        this.qualified = null;
    }

    public TypeLibrary(TypeLibrary parent) {
        this.unqualifiedToQualifiedMap = new HashMap();
        this.unqualified = null;
        this.qualified = null;
    }

    public void lock() {
        this.locked = true;
    }

    private TypeLibrary(String fqnSingleton) {
        if (fqnSingleton.indexOf("$") != -1) {
            this.unqualifiedToQualifiedMap = new HashMap();
            this.unqualified = null;
            this.qualified = null;
            addType(fqnSingleton);
        } else {
            this.unqualifiedToQualifiedMap = null;
            this.qualified = fqnSingleton;
            int idx = fqnSingleton.lastIndexOf(46);
            if (idx == -1) {
                this.unqualified = fqnSingleton;
            } else {
                this.unqualified = fqnSingleton.substring(idx + 1);
            }
        }
        this.locked = true;
    }

    public static TypeLibrary createLibraryForSingleType(String fqnSingleton) {
        if (LombokInternalAliasing.REVERSE_ALIASES.containsKey(fqnSingleton)) {
            TypeLibrary tl = new TypeLibrary();
            tl.addType(fqnSingleton);
            tl.lock();
            return tl;
        }
        return new TypeLibrary(fqnSingleton);
    }

    public void addType(String fullyQualifiedTypeName) {
        Collection<String> oldNames = LombokInternalAliasing.REVERSE_ALIASES.get(fullyQualifiedTypeName);
        if (oldNames != null) {
            for (String oldName : oldNames) {
                addType(oldName);
            }
        }
        String dotBased = fullyQualifiedTypeName.replace("$", ".");
        if (this.locked) {
            throw new IllegalStateException(ModelAuditLogEntry.CHANGE_KEY_LOCKED);
        }
        int idx = fullyQualifiedTypeName.lastIndexOf(46);
        if (idx == -1) {
            throw new IllegalArgumentException("Only fully qualified types are allowed (types in the default package cannot be added here either)");
        }
        String unqualified = fullyQualifiedTypeName.substring(idx + 1);
        if (this.unqualifiedToQualifiedMap == null) {
            throw new IllegalStateException("SingleType library");
        }
        put(unqualified.replace("$", "."), dotBased);
        put(unqualified, dotBased);
        put(fullyQualifiedTypeName, dotBased);
        put(dotBased, dotBased);
        int iIndexOf = fullyQualifiedTypeName.indexOf(36, idx + 1);
        while (true) {
            int idx2 = iIndexOf;
            if (idx2 != -1) {
                String unq = fullyQualifiedTypeName.substring(idx2 + 1);
                put(unq.replace("$", "."), dotBased);
                put(unq, dotBased);
                iIndexOf = fullyQualifiedTypeName.indexOf(36, idx2 + 1);
            } else {
                return;
            }
        }
    }

    public List<String> toQualifieds(String typeReference) {
        if (this.unqualifiedToQualifiedMap == null) {
            if (typeReference.equals(this.unqualified) || typeReference.equals(this.qualified)) {
                return Collections.singletonList(this.qualified);
            }
            return null;
        }
        Object v = this.unqualifiedToQualifiedMap.get(typeReference);
        if (v == null) {
            return Collections.emptyList();
        }
        return v instanceof String ? Collections.singletonList((String) v) : Arrays.asList((String[]) v);
    }

    private void put(String k, String v) {
        String[] nv;
        Object old = this.unqualifiedToQualifiedMap.put(k, v);
        if (old == null) {
            return;
        }
        if (old instanceof String) {
            if (old.equals(v)) {
                return;
            } else {
                nv = new String[]{(String) old, v};
            }
        } else {
            String[] s2 = (String[]) old;
            nv = new String[s2.length + 1];
            System.arraycopy(s2, 0, nv, 0, s2.length);
            nv[s2.length] = v;
        }
        this.unqualifiedToQualifiedMap.put(k, nv);
    }
}
