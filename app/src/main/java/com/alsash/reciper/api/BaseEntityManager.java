package com.alsash.reciper.api;

/**
 * An abstract entity manager
 *
 */
public abstract class BaseEntityManager {
/*
    protected List<E> entities;

    protected BaseEntityManager(int entityCount) {
        this.entities = getEmptyList();
        for (int i = 0; i < entityCount; i++) {
            entities.add(newEntity());
        }
    }

    protected abstract E newEntity();

    public E create() {
        E entity = newEntity();
        entities.add(entity);
        return entity;
    }

    @Nullable
    public E search(long id) {
        for (E entity : entities) {
            if (entity.getId() == id) return entity;
        }
        return null;
    }

    public List<E> list() {
        return entities;
    }

    public List<E> list(int limit) {
        return list(limit, 0);
    }

    public List<E> list(int limit, int offset) {
        List<E> result = getEmptyList();
        for (int i = offset; i < offset + limit; i++) {
            try {
                result.add(entities.get(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return result;
    }

    protected List<E> getEmptyList() {
        return new ArrayList<>();
    }
*/
}