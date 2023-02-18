package fr.springboot.interceptor.implement;



import java.util.Date;

import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import fr.springboot.interceptor.model.AppModel;

/**
 * Interceptor interface 
 * 
 * provides the following methods for intercepting specific events:
 *
 *   afterTransactionBegin():       Called when a Hibernate transaction is begun.
 *   afterTransactionCompletion():  Called after a transaction is committed or rolled back.
 *   beforeTransactionCompletion(): Called before a transaction is committed (but not before rollback).
 *   onCollectionRecreate():        Called before a collection is (re)created.
 *   onCollectionRemove():          Called before a collection is deleted.
 *   onCollectionUpdate():          Called before a collection is updated.
 *   onDelete():                    Called before an object is deleted.
 *   onFlushDirty():                Called when an object is detected to be dirty, during a flush.
 *   onLoad():                      Called just before an object is initialized.
 *   onSave():                      Called before an object is saved.
 *   postFlush():                   Called after a flush.
 *   preFlush():                    Called before a flush. 
 */
@Component
public class InterceptorImplement implements Interceptor {

	private static int count = 0;
	
	@Override
	public boolean onLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("I am in onLoad");
		return Interceptor.super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onSave(Object entity,Object id,Object[] state,String[] propertyNames,Type[] types) {
		System.out.println("I am in onSave : " + (++count));
		if (entity instanceof AppModel) {
	        ((AppModel) entity).setLastModified(new Date());
	    }
		System.out.println( ( ( (AppModel) entity).toString() ) );
		return Interceptor.super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity,Object id,Object[] currentState,Object[] previousState,String[] propertyNames,Type[] types) {
		System.out.println("I am in onFlushDirty : " + count);
	    if (entity instanceof AppModel) {
	        ((AppModel) entity).setLastModified(new Date());
	        System.out.println( ( ( (AppModel) entity).toString() ) );
	    }
	    return Interceptor.super.onFlushDirty(entity, id, currentState, 
	      previousState, propertyNames, types);
	}
}
