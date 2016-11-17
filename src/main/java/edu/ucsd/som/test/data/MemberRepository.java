/**
 * 
 */
package edu.ucsd.som.test.data;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import edu.ucsd.som.test.model.Member;

/**
 * Delta spike repository responsible for retrieving information from the db
 * 
 * @author somdev5
 *
 */
@Repository
public interface MemberRepository extends EntityRepository<Member, Long>{
	
	public Member findById(Long id);

	public Member findByEmail(String email);
	
	@Query(named=Member.FIND_ALL_ORDER_BY_NAME)
	public List<Member> findAllOrderedByName();
}
