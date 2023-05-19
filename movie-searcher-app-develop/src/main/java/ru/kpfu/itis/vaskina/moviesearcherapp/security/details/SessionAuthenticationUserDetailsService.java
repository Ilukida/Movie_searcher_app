package ru.kpfu.itis.vaskina.moviesearcherapp.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.RoleEntity;
import ru.kpfu.itis.vaskina.moviesearcherapp.model.UserEntity;
import ru.kpfu.itis.vaskina.moviesearcherapp.repository.UserRepository;
import ru.kpfu.itis.vaskina.moviesearcherapp.util.mapper.ImageMetadataMapper;

import java.util.List;
import java.util.Set;

public class SessionAuthenticationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageMetadataMapper imageMetadataMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserEntity user  = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return UserAccount.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .password(user.getHashPassword())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .imageMetadata(imageMetadataMapper.imageMetadataToImageMetadataResponse(user.getImageMetadata()))
                    .authorities(getAuthorities(user.getRoles()))
                    .build();
    }

    private List<SimpleGrantedAuthority> getAuthorities(Set<RoleEntity> roles){
        return roles.stream()
                .map(role -> "ROLE_" + role.getRole().name())
                .map(SimpleGrantedAuthority::new)
                .toList();
    }
}
