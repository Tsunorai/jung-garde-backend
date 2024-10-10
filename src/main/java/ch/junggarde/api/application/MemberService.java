package ch.junggarde.api.application;

import ch.junggarde.api.adapter.out.MemberRepository;
import ch.junggarde.api.model.member.Member;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MemberService {
    @Inject
    MemberRepository memberRepository;

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    /*public List<AdministrativeMember> getAdministrativeMembers() {

    }*/
}
