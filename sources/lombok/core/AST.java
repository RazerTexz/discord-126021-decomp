package lombok.core;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.Lombok;
import lombok.core.AST;
import lombok.core.LombokNode;
import lombok.core.configuration.ConfigurationKey;
import lombok.core.debug.HistogramTracker;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/core/AST.SCL.lombok */
public abstract class AST<A extends AST<A, L, N>, L extends LombokNode<A, L, N>, N> {
    private L top;
    private final String fileName;
    private final String packageDeclaration;
    private final ImportList imports;
    private TypeResolver importsAsResolver;
    Map<N, N> identityDetector = new IdentityHashMap();
    private Map<N, L> nodeMap = new IdentityHashMap();
    private boolean changed = false;
    private final Collection<Class<? extends N>> statementTypes;
    private static final HistogramTracker configTracker;
    private static final ConcurrentMap<Class<?>, FieldAccess[]> fieldsOfASTClasses;

    /* JADX INFO: loaded from: app.apk:lombok/core/AST$Kind.SCL.lombok */
    public enum Kind {
        COMPILATION_UNIT,
        TYPE,
        FIELD,
        INITIALIZER,
        METHOD,
        ANNOTATION,
        ARGUMENT,
        LOCAL,
        STATEMENT,
        TYPE_USE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Kind[] valuesCustom() {
            Kind[] kindArrValuesCustom = values();
            int length = kindArrValuesCustom.length;
            Kind[] kindArr = new Kind[length];
            System.arraycopy(kindArrValuesCustom, 0, kindArr, 0, length);
            return kindArr;
        }
    }

    public abstract URI getAbsoluteFileLocation();

    protected abstract L buildTree(N n, Kind kind);

    static {
        configTracker = System.getProperty("lombok.timeConfig") == null ? null : new HistogramTracker("lombok.config");
        fieldsOfASTClasses = new ConcurrentHashMap();
    }

    protected AST(String fileName, String packageDeclaration, ImportList imports, Collection<Class<? extends N>> statementTypes) {
        this.fileName = fileName == null ? "(unknown).java" : fileName;
        this.packageDeclaration = packageDeclaration;
        this.imports = imports;
        this.statementTypes = statementTypes;
    }

    public void setChanged() {
        this.changed = true;
    }

    protected void clearChanged() {
        this.changed = false;
    }

    public boolean isChanged() {
        return this.changed;
    }

    protected void setTop(L top) {
        this.top = top;
    }

    public final String getPackageDeclaration() {
        return this.packageDeclaration;
    }

    public final ImportList getImportList() {
        return this.imports;
    }

    public final TypeResolver getImportListAsTypeResolver() {
        if (this.importsAsResolver != null) {
            return this.importsAsResolver;
        }
        TypeResolver typeResolver = new TypeResolver(getImportList());
        this.importsAsResolver = typeResolver;
        return typeResolver;
    }

    protected L putInMap(L l) {
        this.nodeMap.put((N) l.get(), l);
        this.identityDetector.put((N) l.get(), (N) l.get());
        return l;
    }

    protected Map<N, L> getNodeMap() {
        return this.nodeMap;
    }

    protected void clearState() {
        this.identityDetector = new IdentityHashMap();
        this.nodeMap = new IdentityHashMap();
    }

    protected boolean setAndGetAsHandled(N node) {
        return this.identityDetector.put(node, node) != null;
    }

    public String getFileName() {
        return this.fileName;
    }

    public L top() {
        return this.top;
    }

    public L get(N node) {
        return this.nodeMap.get(node);
    }

    public int getSourceVersion() {
        return 6;
    }

    public int getLatestJavaSpecSupported() {
        return 6;
    }

    L replaceNewWithExistingOld(Map<N, L> oldNodes, L newNode) {
        L oldNode = oldNodes.get(newNode.get());
        L targetNode = oldNode == null ? newNode : oldNode;
        List children = new ArrayList();
        for (L child : newNode.children) {
            LombokNode lombokNodeReplaceNewWithExistingOld = replaceNewWithExistingOld(oldNodes, child);
            children.add(lombokNodeReplaceNewWithExistingOld);
            lombokNodeReplaceNewWithExistingOld.parent = targetNode;
        }
        targetNode.children = LombokImmutableList.copyOf((Collection) children);
        return targetNode;
    }

    /* JADX INFO: loaded from: app.apk:lombok/core/AST$FieldAccess.SCL.lombok */
    protected static class FieldAccess {
        public final Field field;
        public final int dim;

        FieldAccess(Field field, int dim) {
            this.field = field;
            this.dim = dim;
        }
    }

    protected FieldAccess[] fieldsOf(Class<?> c) {
        FieldAccess[] fields = fieldsOfASTClasses.get(c);
        if (fields != null) {
            return fields;
        }
        List<FieldAccess> fieldList = new ArrayList<>();
        getFields(c, fieldList);
        fieldsOfASTClasses.putIfAbsent(c, (FieldAccess[]) fieldList.toArray(new FieldAccess[0]));
        return fieldsOfASTClasses.get(c);
    }

    private void getFields(Class<?> c, Collection<FieldAccess> fields) {
        if (c == Object.class || c == null) {
            return;
        }
        for (Field f : c.getDeclaredFields()) {
            if (!Modifier.isStatic(f.getModifiers())) {
                Class<?> t = f.getType();
                int dim = 0;
                if (t.isArray()) {
                    while (t.isArray()) {
                        dim++;
                        t = t.getComponentType();
                    }
                } else {
                    while (Collection.class.isAssignableFrom(t)) {
                        dim++;
                        t = getComponentType(f.getGenericType());
                    }
                }
                if (shouldDrill(c, t, f.getName())) {
                    Permit.setAccessible(f);
                    fields.add(new FieldAccess(f, dim));
                }
            }
        }
        getFields(c.getSuperclass(), fields);
    }

    private Class<?> getComponentType(Type type) {
        if (type instanceof ParameterizedType) {
            Type component = ((ParameterizedType) type).getActualTypeArguments()[0];
            return component instanceof Class ? (Class) component : Object.class;
        }
        return Object.class;
    }

    private boolean shouldDrill(Class<?> parentType, Class<?> childType, String fieldName) {
        for (Class<?> statementType : this.statementTypes) {
            if (statementType.isAssignableFrom(childType)) {
                return true;
            }
        }
        return false;
    }

    protected Collection<L> buildWithField(Class<L> nodeType, N statement, FieldAccess fa) {
        List<L> list = new ArrayList<>();
        buildWithField0(nodeType, statement, fa, list);
        return list;
    }

    protected boolean replaceStatementInNode(N statement, N oldN, N newN) {
        for (FieldAccess fa : fieldsOf(statement.getClass())) {
            if (replaceStatementInField(fa, statement, oldN, newN)) {
                return true;
            }
        }
        return false;
    }

    private boolean replaceStatementInField(FieldAccess fa, N statement, N oldN, N newN) {
        try {
            Object o = fa.field.get(statement);
            if (o == null) {
                return false;
            }
            if (o == oldN) {
                fa.field.set(statement, newN);
                return true;
            }
            if (fa.dim > 0) {
                if (o.getClass().isArray()) {
                    return replaceStatementInArray(o, oldN, newN);
                }
                if (Collection.class.isInstance(o)) {
                    return replaceStatementInCollection(fa.field, statement, new ArrayList(), (Collection) o, oldN, newN);
                }
                return false;
            }
            return false;
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    private boolean replaceStatementInCollection(Field field, Object fieldRef, List<Collection<?>> chain, Collection<?> collection, N oldN, N newN) throws IllegalAccessException {
        if (collection == null) {
            return false;
        }
        int idx = -1;
        for (Object o : collection) {
            idx++;
            if (o != null) {
                if (Collection.class.isInstance(o)) {
                    Collection<?> newC = (Collection) o;
                    List<Collection<?>> newChain = new ArrayList<>(chain);
                    newChain.add(newC);
                    if (replaceStatementInCollection(field, fieldRef, newChain, newC, oldN, newN)) {
                        return true;
                    }
                }
                if (o == oldN) {
                    setElementInASTCollection(field, fieldRef, chain, collection, idx, newN);
                    return true;
                }
            }
        }
        return false;
    }

    protected void setElementInASTCollection(Field field, Object fieldRef, List<Collection<?>> chain, Collection<?> collection, int idx, N newN) throws IllegalAccessException {
        if (collection instanceof List) {
            ((List) collection).set(idx, newN);
        }
    }

    private boolean replaceStatementInArray(Object array, N oldN, N newN) {
        if (array == null) {
            return false;
        }
        int len = Array.getLength(array);
        for (int i = 0; i < len; i++) {
            Object o = Array.get(array, i);
            if (o != null) {
                if (o.getClass().isArray()) {
                    if (replaceStatementInArray(o, oldN, newN)) {
                        return true;
                    }
                } else if (o == oldN) {
                    Array.set(array, i, newN);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildWithField0(Class<L> nodeType, N child, FieldAccess fa, Collection<L> list) {
        try {
            Object o = fa.field.get(child);
            if (o == null) {
                return;
            }
            if (fa.dim == 0) {
                LombokNode lombokNodeBuildTree = buildTree(o, Kind.STATEMENT);
                if (lombokNodeBuildTree != null) {
                    list.add(nodeType.cast(lombokNodeBuildTree));
                    return;
                }
                return;
            }
            if (o.getClass().isArray()) {
                buildWithArray(nodeType, o, list, fa.dim);
            } else if (Collection.class.isInstance(o)) {
                buildWithCollection(nodeType, o, list, fa.dim);
            }
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildWithArray(Class<L> nodeType, Object array, Collection<L> list, int dim) {
        Object v;
        LombokNode lombokNodeBuildTree;
        if (dim == 1) {
            for (Object v2 : (Object[]) array) {
                if (v2 != null && (lombokNodeBuildTree = buildTree(v2, Kind.STATEMENT)) != null) {
                    list.add(nodeType.cast(lombokNodeBuildTree));
                }
            }
            return;
        }
        Object[] objArr = (Object[]) array;
        int length = objArr.length;
        for (int i = 0; i < length && (v = objArr[i]) != null; i++) {
            buildWithArray(nodeType, v, list, dim - 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildWithCollection(Class<L> nodeType, Object collection, Collection<L> list, int dim) {
        LombokNode lombokNodeBuildTree;
        if (dim == 1) {
            for (Object v : (Collection) collection) {
                if (v != null && (lombokNodeBuildTree = buildTree(v, Kind.STATEMENT)) != null) {
                    list.add(nodeType.cast(lombokNodeBuildTree));
                }
            }
            return;
        }
        Iterator it = ((Collection) collection).iterator();
        while (it.hasNext()) {
            buildWithCollection(nodeType, it.next(), list, dim - 1);
        }
    }

    public final <T> T readConfiguration(ConfigurationKey<T> configurationKey) {
        long jStart = configTracker == null ? 0L : configTracker.start();
        try {
            return (T) LombokConfiguration.read((ConfigurationKey) configurationKey, (AST<?, ?, ?>) this);
        } finally {
            if (configTracker != null) {
                configTracker.end(jStart);
            }
        }
    }
}
